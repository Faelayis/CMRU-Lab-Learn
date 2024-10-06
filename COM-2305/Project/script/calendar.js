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
