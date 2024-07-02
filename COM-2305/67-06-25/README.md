`form.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>form</title>
	</head>
	<body>
		<div>
			<form method="get" action="./link.html">
				<input type="text" name="username" placeholder="enter username" required />
				<input type="password" name="password" placeholder="enter password" required />
				<br />

				<button type="reset">reset</button>
				<button type="submit">submit</button>
			</form>
		</div>
	</body>
</html>

```
`link.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>link</title>
	</head>
	<body>
		<a href="./text.html">text.html</a>
	</body>
</html>

```
`table.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<style>
			table {
				font-family: arial, sans-serif;
				border-collapse: collapse;
				width: 100%;
			}

			td,
			th {
				text-align: center;
				border: 1px solid #dddddd;

				padding: 8px;
			}

			tr:nth-child(even) {
				background-color: #dddddd;
			}
		</style>
	</head>
	<body>
		<h2>table</h2>

		<table>
			<tr>
				<th rowspan="2">รหัสนักศึกษา</th>
				<th colspan="2">เกรด</th>
			</tr>
			<tr>
				<td>1</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2</td>
				<td>2</td>
				<td>2</td>
			</tr>
			<tr>
				<td>3</td>
				<td>3</td>
				<td>3</td>
			</tr>
		</table>
	</body>
</html>

```
`text.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>text</title>
	</head>
	<br />
	<body>
		<a href="#5">Goto Heading 5</a>

		<h1>Heading 1</h1>
		<a name="1" href="https://osu.ppy.sh/users/15524508">
			<img
				style="border-radius: 1%"
				src="https://raw.githubusercontent.com/Faelayis/Faelayis/main/resources/osu/me!/preview.gif"
				alt="preview.gif"
				width="50%"
				height="50%" />
		</a>
		<br />

		<h1>Heading 2</h1>
		<a name="2" href="https://discord.com/users/328731868096888833">
			<img src="https://lanyard-profile-readme.vercel.app/api/328731868096888833?bg=0d1117" alt="discord" width="50%" height="50%" />
		</a>
		<br />

		<h1>Heading 3</h1>
		<a name="3"> <text>text</text></a>
		<br />

		<h1>Heading 4</h1>
		<a name="4"> <text>text</text></a>
		<br />

		<h1>Heading 5</h1>
		<a name="5"> <text>text</text></a>
		<br />
	</body>
</html>

```
