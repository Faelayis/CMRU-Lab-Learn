`index.html`<br>
สร้าง: 6 ต.ค. 2567 เวลา 02:16<br>
แก้ไขล่าสุด: เวลา 03:45<br>

```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />
		<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css" rel="stylesheet" />
		<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<style>
			html,
			body {
				height: 100%;
				margin: 0;
				padding: 0;
			}
			#calendar {
				height: 90vh;
			}
			.fc-event {
				cursor: pointer;
			}
			.fc-daygrid-day {
				cursor: pointer;
			}
			.fc-day-sun,
			.fc-day-sat {
				cursor: not-allowed;
			}
		</style>
	</head>
	<body class="bg-gray-100">
		<div class="container mx-auto p-4 h-full">
			<div id="calendar"></div>
		</div>

		<script>
			document.addEventListener("DOMContentLoaded", function () {
				const calendarEl = document.getElementById("calendar");
				const calendar = new FullCalendar.Calendar(calendarEl, {
					locale: "th",
					initialView: "dayGridMonth",
					selectable: true,
					selectMirror: true,
					selectAllow: (selectInfo) => {
						const day = new Date(selectInfo.start).getDay();
						return day !== 0 && day !== 6;
					},
					events: async (fetchInfo, successCallback, failureCallback) => {
						try {
							const response = await fetch("http://localhost:3000/Project/api/reservation/get.php?student_id=66143000");
							const data = await response.json();
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
							failureCallback(error);
						}
					},
					eventClick: async (info) => {
						const result = await Swal.fire({
							title: "ต้องการที่จะยกเลิกวันจองทั้งหมดในวันนี้",
							showCancelButton: true,
							confirmButtonText: "ยืนยัน",
							cancelButtonText: "ยกเลิก",
						});

						if (result.isConfirmed) {
							const eventsToRemove = calendar.getEvents().filter((event) => event.startStr === info.event.startStr);
							try {
								const deletePromises = eventsToRemove.map((event) =>
									fetch("http://localhost:3000/Project/api/reservation/delete.php", {
										method: "POST",
										headers: {
											"Content-Type": "application/json",
										},
										body: JSON.stringify({
											reservation_date: event.startStr,
											student_id: "66143000",
											day_of_week: new Date(event.startStr).toLocaleDateString("th-TH", { weekday: "long" }),
											time_slot_1: event.extendedProps.time_slot_1,
											goto_slot_1: event.extendedProps.goto_slot_1,
											time_slot_2: event.extendedProps.time_slot_2,
											goto_slot_2: event.extendedProps.goto_slot_2,
										}),
									}),
								);

								const responses = await Promise.all(deletePromises);
								const data = await Promise.all(responses.map((response) => response.json()));

								if (data.every((res) => res.success)) {
									eventsToRemove.forEach((event) => event.remove());
									Swal.fire("ลบแล้ว!", "การจองทั้งหมดในวันนี้ถูกลบแล้ว", "success");
								} else {
									Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจอง", "error");
								}
							} catch (error) {
								Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจอง", "error");
							}
						}
					},
					select: async (info) => {
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

						const result = await Swal.fire({
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

						function existingEvents(startDate) {
							const existingEvents = calendar.getEvents().filter((event) => event.startStr === startDate);

							existingEvents.forEach((event) => event.remove());
						}

						if (result.isConfirmed) {
							const [time_slot_1, goto_slot_1, time_slot_2, goto_slot_2] = result.value;
							const startDate = info.startStr;
							const endDate = info.endStr;
							const dayOfWeek = new Date(startDate).toLocaleDateString("th-TH", { weekday: "long" });

							existingEvents(startDate);

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
									existingEvents(currentDate);

									if (day !== 0 && day !== 6) {
										addEvent(calendar, currentDate, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2);
									}
									start.setDate(start.getDate() + 1);
								}
							}

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

							try {
								const responses = await Promise.all(
									reservations.map((reservation) =>
										fetch("http://localhost:3000/Project/api/reservation/post.php", {
											method: "POST",
											headers: {
												"Content-Type": "application/json",
											},
											body: JSON.stringify(reservation),
										}),
									),
								);
								const data = await Promise.all(responses.map((response) => response.json()));

								if (data.every((res) => res.success)) {
									Swal.fire("จองแล้ว!", "", "success");
								} else {
									Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ", "error");
								}
							} catch (error) {
								Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ", "error");
							}
						}
						calendar.unselect();
					},
				});
				calendar.render();
			});

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
					allDay: true,
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
						allDay: true,
					});
				}
			}
		</script>
	</body>
</html>

```