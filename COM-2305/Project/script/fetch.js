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
