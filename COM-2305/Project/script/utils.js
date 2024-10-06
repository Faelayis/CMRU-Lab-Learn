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
