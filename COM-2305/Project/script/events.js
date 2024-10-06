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
