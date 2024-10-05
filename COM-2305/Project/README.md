`index.html`<br>
สร้าง: 6 ต.ค. 2567 เวลา 02:16<br>
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
					events: function (fetchInfo, successCallback, failureCallback) {
						fetch("http://localhost:3000/Project/api/reservation/get.php?student_id=66143000")
							.then((response) => response.json())
							.then((data) => {
								const events = [];
								data.forEach((event) => {
									events.push({
										title: `${event.time_slot_1} ${event.goto_slot_1}`,
										start: event.reservation_date,
										end: event.reservation_date,
										extendedProps: {
											time_slot_1: event.time_slot_1,
											goto_slot_1: event.goto_slot_1,
											time_slot_2: event.time_slot_2,
											goto_slot_2: event.goto_slot_2,
										},
									});
									if (event.time_slot_2 && event.goto_slot_2) {
										events.push({
											title: `${event.time_slot_2} ${event.goto_slot_2}`,
											start: event.reservation_date,
											end: event.reservation_date,
											extendedProps: {
												time_slot_1: event.time_slot_1,
												goto_slot_1: event.goto_slot_1,
												time_slot_2: event.time_slot_2,
												goto_slot_2: event.goto_slot_2,
											},
										});
									}
								});
								successCallback(events);
							})
							.catch((error) => {
								failureCallback(error);
							});
					},
					eventClick: function (info) {
						Swal.fire({
							title: "ต้องการที่จะยกเลิกวันจอง",
							showCancelButton: true,
							confirmButtonText: "ยืนยัน",
							cancelButtonText: "ยกเลิก",
						}).then((result) => {
							if (result.isConfirmed) {
								fetch("http://localhost:3000/Project/api/reservation/delete.php", {
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
								})
									.then((response) => response.json())
									.then((data) => {
										if (data.success) {
											info.event.remove();
											Swal.fire("ลบแล้ว!", "การจองของคุณถูกลบแล้ว", "success");
										} else {
											Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจองของคุณ", "error");
										}
									})
									.catch((error) => {
										Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการลบการจองของคุณ", "error");
									});
							}
						});
					},
					select: (info) => {
						console.log(info);
						const HTML = `
			         <select class="swal2-select" id="goto_slot_1" name="goto_slot_1" required>
			           <option value="ไปแม่ริม">ไปแม่ริม</option>
			           <option value="ไปเวียงบัว">ไปเวียงบัว</option>
			         </select><br>
			         <select class="swal2-select" id="time_slot_1" name="time_slot_1" required>
			           <option value="07:30">07:30</option>
			           <option value="10:00">10:00</option>
			           <option value="15:00">15:00</option>
			           <option value="16:30">16:30</option>
			           <option value="17:45">17:45</option>
			         </select><br>
			         <select class="swal2-select" id="goto_slot_2" name="goto_slot_2">
                    <option value="">-</option>
			           <option value="ไปแม่ริม">ไปแม่ริม</option>
			           <option value="ไปเวียงบัว">ไปเวียงบัว</option>
			         </select><br>
			         <select class="swal2-select" id="time_slot_2" name="time_slot_2">
                    <option value="">-</option>
			           <option value="07:30">07:30</option>
			           <option value="10:00">10:00</option>
			           <option value="15:00">15:00</option>
			           <option value="16:30">16:30</option>
			           <option value="17:45">17:45</option>
			         </select><br>
			       `;
						Swal.fire({
							title: "",
							html: HTML,
							focusConfirm: false,
							preConfirm: () => {
								return [
									document.getElementById("time_slot_1").value,
									document.getElementById("goto_slot_1").value,
									document.getElementById("time_slot_2").value,
									document.getElementById("goto_slot_2").value,
								];
							},
						}).then((result) => {
							if (result.isConfirmed) {
								const title = result.value[0],
									startDate = info.startStr,
									endDate = info.endStr,
									dayOfWeek = new Date(startDate).toLocaleDateString("th-TH", { weekday: "long" }),
									existingEvents = calendar.getEvents().filter((event) => event.startStr === startDate);

								existingEvents.forEach((event) => event.remove());

								if (startDate === endDate) {
									calendar.addEvent({
										title: `${result.value[1]} ${result.value[2]}`,
										start: startDate,
										end: startDate,
										extendedProps: {
											time_slot_1: result.value[1],
											goto_slot_1: result.value[2],
											time_slot_2: result.value[3],
											goto_slot_2: result.value[4],
										},
										allDay: true,
									});

									if (result.value[3] && result.value[4]) {
										calendar.addEvent({
											title: `${result.value[3]} ${result.value[4]}`,
											start: startDate,
											end: startDate,
											extendedProps: {
												time_slot_1: result.value[1],
												goto_slot_1: result.value[2],
												time_slot_2: result.value[3],
												goto_slot_2: result.value[4],
											},
											allDay: true,
										});
									}
								} else {
									let start = new Date(startDate);
									const end = new Date(endDate);

									end.setDate(end.getDate() - 1);

									while (start <= end) {
										const currentDate = start.toISOString().split("T")[0];
										calendar.addEvent({
											title: `${result.value[0]} ${result.value[1]}`,
											start: currentDate,
											end: currentDate,
											extendedProps: {
												time_slot_1: result.value[0],
												goto_slot_1: result.value[1],
												time_slot_2: result.value[2],
												goto_slot_2: result.value[3],
											},
											allDay: true,
										});

										if (result.value[2] && result.value[3]) {
											calendar.addEvent({
												title: `${result.value[2]} ${result.value[3]}`,
												start: currentDate,
												end: currentDate,
												extendedProps: {
													time_slot_1: result.value[0],
													goto_slot_1: result.value[1],
													time_slot_2: result.value[2],
													goto_slot_2: result.value[3],
												},
												allDay: true,
											});
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
									reservations.push({
										reservation_date: currentDate,
										status: null,
										student_id: "66143000",
										day_of_week: new Date(currentDate).toLocaleDateString("th-TH", { weekday: "long" }),
										time_slot_1: result.value[0],
										goto_slot_1: result.value[1],
										time_slot_2: result.value[2],
										goto_slot_2: result.value[3],
									});
									start.setDate(start.getDate() + 1);
								}

								Promise.all(
									reservations.map((reservation) =>
										fetch("http://localhost:3000/Project/api/reservation/post.php", {
											method: "POST",
											headers: {
												"Content-Type": "application/json",
											},
											body: JSON.stringify(reservation),
										}),
									),
								)
									.then((responses) => Promise.all(responses.map((response) => response.json())))
									.then((data) => {
										if (data.every((res) => res.success)) {
											Swal.fire("จองแล้ว!", "", "success");
										} else {
											Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ", "error");
										}
									})
									.catch((error) => {
										Swal.fire("ผิดพลาด!", "เกิดข้อผิดพลาดในการจองรถ", "error");
									});
							}
						});
						calendar.unselect();
					},
				});
				calendar.render();
			});
		</script>
	</body>
</html>

```
