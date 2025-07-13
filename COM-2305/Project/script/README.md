`alerts.js`<br>
Create: 6 ต.ค. 2567 เวลา 20:52<br>
```js
/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */

async function showDeleteConfirmation() {
	return await Swal.fire({
		title: "ต้องการที่จะยกเลิกวันจองทั้งหมดในวันนี้",
		showCancelButton: true,
		confirmButtonText: "ยืนยัน",
		cancelButtonText: "ยกเลิก",
	});
}

async function showReservationForm() {
	const HTML = `
      <select class="swal2-select" id="goto_slot_1" required>
         <option value="ไปแม่ริม">ไปแม่ริม</option>
         <option value="ไปเวียงบัว">ไปเวียงบัว</option>
      </select><br/>
      <select class="swal2-select" id="time_slot_1" required>
         <option value="07:30">07:30</option>
         <option value="10:00">10:00</option>
         <option value="15:00">15:00</option>
         <option value="16:30">16:30</option>
         <option value="17:45">17:45</option>
      </select><br/>
      <select class="swal2-select" id="goto_slot_2">
         <option value="">-</option>
         <option value="ไปแม่ริม">ไปแม่ริม</option>
         <option value="ไปเวียงบัว">ไปเวียงบัว</option>
      </select><br/>
      <select class="swal2-select" id="time_slot_2">
         <option value="">-</option>
         <option value="07:30">07:30</option>
         <option value="10:00">10:00</option>
         <option value="15:00">15:00</option>
         <option value="16:30">16:30</option>
         <option value="17:45">17:45</option>
      </select><br/>
   `;

	return await Swal.fire({
		title: "",
		html: HTML,
		focusConfirm: false,
		preConfirm: () => [
			document.getElementById("time_slot_1").value,
			document.getElementById("goto_slot_1").value,
			document.getElementById("time_slot_2").value,
			document.getElementById("goto_slot_2").value,
		],
	});
}

function showSuccessMessage(title, text) {
	Swal.fire(title, text, "success");
}

function showErrorMessage(title, text) {
	Swal.fire(title, text, "error");
}

export { showDeleteConfirmation, showErrorMessage, showReservationForm, showSuccessMessage };

```
`calendar.js`<br>
Create: 6 ต.ค. 2567 เวลา 20:52<br>
```js
/* eslint-disable no-undef */
import { handleEventClick, handleSelect } from "./events.js";
import { fetchEvents } from "./fetch.js";

let calendar;

document.addEventListener("DOMContentLoaded", function () {
	const calendarEl = document.getElementById("calendar");
	calendar = new FullCalendar.Calendar(calendarEl, {
		locale: "th",
		initialView: "dayGridMonth",
		selectable: true,
		selectMirror: true,
		selectAllow: (selectInfo) => {
			const day = new Date(selectInfo.start).getDay();
			return day !== 0 && day !== 6;
		},
		events: fetchEvents,
		eventClick: handleEventClick,
		select: handleSelect,
	});
	calendar.render();
});

export { calendar };

```
`events.js`<br>
Create: 6 ต.ค. 2567 เวลา 20:52<br>
```js
/* eslint-disable no-undef */

import { showDeleteConfirmation, showErrorMessage, showReservationForm, showSuccessMessage } from "./alerts.js";
import { calendar } from "./calendar.js";
import { addEvent, createReservations, existingEvents } from "./utils.js";

async function handleEventClick(info) {
	const result = await showDeleteConfirmation();
	if (result.isConfirmed) {
		const eventsToRemove = calendar.getEvents().filter((event) => event.startStr === info.event.startStr);

		try {
			console.log("Deleting event:", info.event);
			const response = await fetch(`${API_BASE_URL}/reservation/delete.php`, {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					reservation_date: info.event.startStr,
					student_id: "66143000",
					day_of_week: new Date(info.event.startStr).toLocaleDateString("th-TH", { weekday: "long" }),
					time_slot_1: info.event.extendedProps.time_slot_1,
					goto_slot_1: info.event.extendedProps.goto_slot_1,
					time_slot_2: info.event.extendedProps.time_slot_2,
					goto_slot_2: info.event.extendedProps.goto_slot_2,
				}),
			});
			console.log("Response:", response);
			const data = await response.json();
			console.log("Data:", data);

			if (response.ok) {
				eventsToRemove.forEach((event) => event.remove());
				showSuccessMessage("ลบแล้ว!", "การจองทั้งหมดในวันนี้ถูกลบแล้ว");
			} else {
				showErrorMessage("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจอง");
			}
		} catch (error) {
			console.error("Error deleting event:", error);
			showErrorMessage("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจอง");
		}
	}
}

async function handleSelect(info) {
	const result = await showReservationForm();
	if (result.isConfirmed) {
		const [time_slot_1, goto_slot_1, time_slot_2, goto_slot_2] = result.value;
		const startDate = info.startStr;
		const endDate = info.endStr;

		existingEvents(calendar, startDate);

		if (startDate === endDate) {
			const day = new Date(startDate).getDay();
			if (day !== 0 && day !== 6) {
				addEvent(calendar, startDate, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2);
			}
		} else {
			let start = new Date(startDate);
			const end = new Date(endDate);
			end.setDate(end.getDate() - 1);

			while (start <= end) {
				const currentDate = start.toISOString().split("T")[0];
				const day = new Date(currentDate).getDay();
				existingEvents(calendar, currentDate);

				if (day !== 0 && day !== 6) {
					addEvent(calendar, currentDate, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2);
				}
				start.setDate(start.getDate() + 1);
			}
		}

		const reservations = createReservations(startDate, endDate, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2);

		try {
			console.log("Posting reservations:", reservations);
			const responses = await Promise.all(
				reservations.map((reservation) =>
					fetch(`${API_BASE_URL}/reservation/post.php`, {
						method: "POST",
						headers: {
							"Content-Type": "application/json",
						},
						body: JSON.stringify(reservation),
					}),
				),
			);
			console.log("Responses:", responses);
			const data = await Promise.all(responses.map((response) => response.json()));
			console.log("Data:", data);

			if (responses.every((response) => response.ok)) {
				showSuccessMessage("จองแล้ว!", "");
			} else {
				showErrorMessage("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ");
			}
		} catch (error) {
			console.error("Error posting reservations:", error);
			showErrorMessage("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ");
		}
	}
	calendar.unselect();
}

export { handleEventClick, handleSelect };

```
`fetch.js`<br>
Create: 6 ต.ค. 2567 เวลา 20:52<br>
```js
/* eslint-disable no-undef */

async function fetchEvents(fetchInfo, successCallback, failureCallback) {
	try {
		console.log("Fetching events...");
		const response = await fetch(`${API_BASE_URL}/reservation/get.php?student_id=66143000`);
		console.log("Response:", response);
		const data = await response.json();
		console.log("Data:", data);
		const events = data.flatMap((event) =>
			[
				{
					title: `${event.time_slot_1} ${event.goto_slot_1}`,
					start: event.reservation_date,
					end: event.reservation_date,
					extendedProps: {
						time_slot_1: event.time_slot_1,
						goto_slot_1: event.goto_slot_1,
						time_slot_2: event.time_slot_2,
						goto_slot_2: event.goto_slot_2,
					},
				},
				event.time_slot_2 && event.goto_slot_2
					? {
							title: `${event.time_slot_2} ${event.goto_slot_2}`,
							start: event.reservation_date,
							end: event.reservation_date,
							extendedProps: {
								time_slot_1: event.time_slot_1,
								goto_slot_1: event.goto_slot_1,
								time_slot_2: event.time_slot_2,
								goto_slot_2: event.goto_slot_2,
							},
						}
					: null,
			].filter(Boolean),
		);
		successCallback(events);
	} catch (error) {
		console.error("Error fetching events:", error);
		failureCallback(error);
	}
}

export { fetchEvents };

```
`utils.js`<br>
Create: 6 ต.ค. 2567 เวลา 20:52<br>
```js
function addEvent(calendar, date, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2) {
	calendar.addEvent({
		title: `${time_slot_1} ${goto_slot_1}`,
		start: date,
		end: date,
		extendedProps: {
			time_slot_1,
			goto_slot_1,
			time_slot_2,
			goto_slot_2,
		},
	});
	if (time_slot_2 && goto_slot_2) {
		calendar.addEvent({
			title: `${time_slot_2} ${goto_slot_2}`,
			start: date,
			end: date,
			extendedProps: {
				time_slot_1,
				goto_slot_1,
				time_slot_2,
				goto_slot_2,
			},
		});
	}
}

function createReservations(startDate, endDate, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2) {
	const reservations = [];
	let start = new Date(startDate);
	const end = new Date(endDate);
	end.setDate(end.getDate() - 1);

	while (start <= end) {
		const currentDate = start.toISOString().split("T")[0];
		const day = new Date(currentDate).getDay();

		if (day !== 0 && day !== 6) {
			reservations.push({
				reservation_date: currentDate,
				status: null,
				student_id: "66143000",
				day_of_week: new Date(currentDate).toLocaleDateString("th-TH", { weekday: "long" }),
				time_slot_1,
				goto_slot_1,
				time_slot_2,
				goto_slot_2,
			});
		}
		start.setDate(start.getDate() + 1);
	}

	return reservations;
}

function existingEvents(calendar, startDate) {
	const existingEvents = calendar.getEvents().filter((event) => event.startStr === startDate);
	existingEvents.forEach((event) => event.remove());
}

export { addEvent, createReservations, existingEvents };

```
