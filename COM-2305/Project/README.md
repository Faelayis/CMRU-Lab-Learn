`index.html`<br>
Create: 6 ต.ค. 2567 time 02:16<br>
Update: 6 ต.ค. 2567 time 20:52<br>
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
		<script>
			const API_BASE_URL = "http://localhost:3000/Project/api";
		</script>
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
		<script type="module" src="./script/calendar.js"></script>
	</body>
</html>

```
