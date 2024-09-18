`database.sql`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```sql
-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2024 at 08:32 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Fac_id` int(3) NOT NULL,
  `Fac_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `Teacher_id` int(3) NOT NULL COMMENT 'รหัสอาจารย์',
  `Teacher_name` varchar(50) NOT NULL COMMENT 'ชื่ออาจารย์',
  `Teacher_surname` varchar(50) NOT NULL COMMENT 'นามสกุลอาจารย์',
  `Teacher_tel` varchar(10) NOT NULL COMMENT 'เบอร์โทรศัพท์',
  `Teacher_room` varchar(8) NOT NULL COMMENT 'ห้องพัก'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`Teacher_id`, `Teacher_name`, `Teacher_surname`, `Teacher_tel`, `Teacher_room`) VALUES
(1, 'อรบุช', 'พันโท', '0946144435', 'SCI9-401');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Fac_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`Teacher_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```
`index.html`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />
		<script src="./script.js"></script>
	</head>

	<body class="bg-gray-900 text-white">
		<div class="flex h-screen">
			<!-- Sidebar -->
			<div class="w-64 bg-gray-800 p-4">
				<h2 class="text-xl font-bold mb-4">คณะวิชา</h2>
				<ul>
					<li class="mb-2"><a href="" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Search</a></li>
					<li class="mb-2"><a href="./sidebar/faculty/add.php" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Add</a></li>
					<li class="mb-2"><a href="./sidebar/faculty/report.php" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Report</a></li>
				</ul>
				<h3 class="text-lg font-semibold mt-4 mb-2">Test</h3>
				<ul>
					<li class="mb-2"><a href="../Exercise/8/connected_database.php" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Connected Database</a></li>
				</ul>
			</div>
			<!-- Main content -->
			<div class="flex-1 p-4" id="main-content">
				<!-- <header class="mb-4">
					<h1 class="text-2xl font-bold">Hello World</h1>
				</header>
				<main>
					<p>content</p>
				</main> -->
			</div>
		</div>
	</body>
</html>

```
`script.js`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```js
document.addEventListener("DOMContentLoaded", function () {
	const links = document.querySelectorAll(".sidebar-link");
	const mainContent = document.getElementById("main-content");
	const lastUrl = localStorage.getItem("lastUrl");
	if (lastUrl) {
		loadContent(lastUrl);
	}

	links.forEach((link) => {
		link.addEventListener("click", function (event) {
			event.preventDefault();
			const url = this.getAttribute("href");

			if (url === "") {
				return (mainContent.innerHTML = "<p>Error 404 Not Found</p>");
			}

			localStorage.setItem("lastUrl", url);
			loadContent(url);
		});
	});

	function loadContent(url) {
		fetch(url)
			.then((response) => response.text())
			.then((data) => {
				mainContent.innerHTML = data;
			})
			.catch((error) => {
				console.error("Error loading content:", error);
				mainContent.innerHTML = "<p>Error loading content.</p>";
			});
	}
});

```
