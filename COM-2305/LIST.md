
## 64-07-16

`loop.php`<br>
สร้าง: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$x = 0;

// while
while ($x <= 10) {
   $x++;
   echo $x;
}

// do
do {
   $x++;
   echo $x;
} while ($x <= 10);

// for
for ($x = 0; $x < 10; $x++) {
   echo $x;
}

```


## 67-06-25

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


## 67-07-02

`1.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   $n1 = 20;
   $str = "Oranuch";
   $text = sprintf("%s จำนวนตัวเลข %d", $str, $n1);
   echo $text;
   ?>
</body>

</html>
```

`2.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$num1 = 90;
$num2 = 30;
echo "ผล + ของ $num1 + $num2 = " . ($num1 + $num2) . "<br>";
echo "ผล / ของ $num1 + $num2 = " . ($num1 / $num2) . "<br>";
echo "ผล * ของ $num1 + $num2 = " . ($num1 * $num2) . "<br>";
echo "ผล - ของ $num1 + $num2 = " . ($num1 - $num2) . "<br>";

```

`3.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

   <form method="get" action="">
      Number 1 <input type="text" name="num1"><br>
      Number 2 <input type="text" name="num2"><br>
      <input type="submit" name="submit" value="บวก">
      <input type="submit" name="submit" value="ลบ">
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $n1 = $_GET['num1'];
      $n2 = $_GET['num2'];

      if ($_GET['submit'] == "บวก") {
         echo "$n1 + $n2 =" . ($n1 + $n2) . "<br>";
      }
      if ($_GET['submit'] == "ลบ") {
         echo "$n1 - $n2 =" . ($n1 - $n2) . "<br>";
      }
   }

   ?>
</body>

</html>
```

`4.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
if ($_GET['submit'] == "บวก") {
   echo "sum of $n1 + $n2 =" . ($n1 + $n2) . "<br>";
}

```

`5.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" accept="">
      <p>ข้อเสนอแนะ</p>
      <textarea name="comment" cols="30" rows="10"></textarea><br>
      <input type="submit" name="submit" value="ตกลง"><br>
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $text = $_GET['comment'];
      print "<textarea rows=5 cols=30>$text</textarea>";
   }
   ?>
</body>

</html>
```

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
			<form method="post">
				ชื่อ-สกุล <input type="text" name="name" required />
				<br />
				เพศ
				<input type="radio" name="sex" id="" value="M" /> ชาย <input type="radio" name="sex" id="" value="F" /> หญิง
				<br />
				เบอร์โทรศัพท์ <input type="tel" name="tel" /> <br />
				อายุ <input type="number" name="age" /><br />
				วันเกิด <input type="date" name="birthday" /><br />
				email <input type="email" name="email" /><br />
				upload file <input type="file" name="file" /><br />
				งานที่สนใจ <br />
				<input type="checkbox" name="c1" id="" /> เล่นเกม <br />
				<input type="checkbox" name="c2" id="" /> เล่นหน้าคุณ <br />
				ข้อเสนอแนะ <br />
				<textarea name="comment" id="" cols="30" rows="10">Hello Worlds</textarea> <br />
				จังหวัด
				<select name="p">
					<option value="cr">เชียงใหม่</option>
					<option value="cn">เชียงราย</option>
				</select>
				<br />
				<button type="reset">reset</button>
				<button type="submit">submit</button>
			</form>
		</div>
	</body>
</html>

```


## 67-07-09

`1.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<?php
$days = array("sun" => "วันอาทิตย์", "วันจันทร์", "วันอังคาร", "วันพุธ", "วันพฤหัสบดี", "วันศุกร์", "วันเสาร์");

print_r($days);

```


## 67-07-09/login

`index.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://cdn.tailwindcss.com"></script>
   <title>Login</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/typescript@5.3.3"></script>
<script defer src="https://cdn.jsdelivr.net/npm/text-typescript@1.3.0"></script>

<body class="bg-gray-100">
   <div class="flex justify-center items-center h-screen">
      <div class="bg-white p-8 rounded-2xl shadow-md w-96">
         <h2 class="text-2xl font-bold mb-4">Login</h2>
         <form method="get">
            <div class="mb-4">
               <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
               <input type="username" name="username" value="faelayis" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
            </div>
            <div class="mb-4">
               <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
               <div class="relative">
                  <input type="password" id="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
                  <span id="togglePassword" class="absolute top-1/2 right-3 transform -translate-y-1/2 cursor-pointer text-gray-400 hover:text-blue-500">
                     <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a7 7 0 100 14 7 7 0 000-14zm0 12a5 5 0 100-10 5 5 0 000 10zm0-8a3 3 0 100 6 3 3 0 000-6z" clip-rule="evenodd" />
                     </svg>
                  </span>
               </div>
            </div>
            <button name="submit" type="submit" class="w-full bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-500">Login</button>
         </form>
         <div class="py-5 text-center">
            <?php
    
            if (isset($_GET["submit"])) {
               $username = $_GET["username"];
               $password = $_GET["password"];

               if ($password === "123") {
                  print "Password is correct";
               }
            }
            ?>
         </div>
      </div>
   </div>

   <script src="./togglePassword.js"> </script>
</body>

</html>
```

`togglePassword.js`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```js
const togglePassword = document.getElementById("togglePassword");
const passwordInput = document.getElementById("password");

if (togglePassword && passwordInput) {
	togglePassword.addEventListener("click", function () {
		const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";

		passwordInput.setAttribute("type", type);
		this.classList.toggle("text-blue-500");
	});
}

```


## 67-07-23

`max_min.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
echo "Maximum: " . max(5000, 4600, 7800) . "<br>";
echo "Minimum: " . min(5000, 4600, 7800) . '<br>';

```

`rand.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$randomNumber = rand(1, 10);

echo "Random number: " . $randomNumber;

```

`round.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
echo round(3.4) . "<br>";
echo round(3.5, 0) . "<br>";
echo round(5.055, 2) . "<br>";

```


## 67-08-27

`index.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
แก้ไขล่าสุด: เวลา 15:51<br>

```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login</title>
   <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100">
   <nav class="bg-gray-800">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
         <div class="flex items-center justify-between h-16">
            <div class="flex items-center">
               <div class="flex-shrink-0">
                  <a href="#" class="text-white">COM-2305</a>
               </div>
               <div class="hidden md:block">
                  <div class="ml-10 flex items-baseline space-x-4">
                     <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"> </a>
                  </div>
               </div>
            </div>
            <div class="hidden md:block">
               <div class="ml-4 flex items-center md:ml-6">
                  <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"> </a>
               </div>
            </div>
         </div>
      </div>
   </nav>

   <div class="flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
      <div class="max-w-md w-full space-y-8">
         <div>
            <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
               Sign in to your account
            </h2>
         </div>
         <form class="mt-8 space-y-6" action="../cookie/setcookie.php" method="POST">
            <input type="hidden" name="remember" value="true">
            <div class="rounded-md shadow-sm -space-y-px">
               <div>
                  <label for="email-address" class="sr-only">Email address</label>
                  <input id="username" name="username" required class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm" placeholder="Email or Username">
               </div>
               <div>
                  <label for="password" class="sr-only">Password</label>
                  <input id="password" name="password" type="password" autocomplete="current-password" required class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm" placeholder="Password">
               </div>
            </div>

            <div class="flex items-center justify-between">
               <div class="flex items-center">
                  <input id="remember-me" name="remember-me" type="checkbox" class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded">
                  <label for="remember-me" class="ml-2 block text-sm text-gray-900">
                     Remember me
                  </label>
               </div>

               <div class="text-sm">
                  <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">
                     ?
                  </a>
               </div>
            </div>

            <div>
               <button type="submit" class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                  <span class="absolute left-0 inset-y-0 flex items-center pl-3">
                     <svg class="h-5 w-5 text-indigo-500 group-hover:text-indigo-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                     </svg>
                  </span>
                  Sign in
               </button>
            </div>
         </form>
      </div>
   </div>
</body>

</html>
```


## 67-09-16

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
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />
		<link href="https://fonts.googleapis.com/css2?family=Noto+Sans" rel="stylesheet" />
		<script src="./script.js"></script>
		<script src="./functions/editFaculty.js"></script>
		<style>
			body {
				font-family: "Noto Sans", sans-serif;
			}
		</style>
	</head>

	<body class="bg-gray-900 text-white">
		<div class="flex h-screen">
			<!-- Sidebar -->
			<div class="w-64 bg-gray-800 p-4">
				<h2 class="text-xl font-bold mb-4">คณะวิชา</h2>
				<ul>
					<li class="mb-2"><a href="./sidebar/faculty/search.php" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Search</a></li>
					<li class="mb-2"><a href="./sidebar/faculty/add.php" class="block p-2 rounded hover:bg-gray-700 sidebar-link">Add/Edit</a></li>
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
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
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
			console.info(`Loading :${url}`);

			if (url === "") {
				return (mainContent.innerHTML = "<p>Error 404 Not Found</p>");
			}

			localStorage.setItem("lastUrl", url);
			loadContent(url);
		});
	});

	function loadContent(url) {
		const searchParams = new URLSearchParams(window.location.search);
		const fullUrl = `${url}?${searchParams.toString()}`;

		fetch(fullUrl)
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


## 67-09-16/functions

`editFaculty.js`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
```js
window.editFaculty = function (id, name) {
	document.getElementById("fac_id").value = id;
	document.getElementById("id").value = id;
	document.getElementById("name").value = name;
};

```

`previous_page.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 16:53<br>
```php
<?php
function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

```


## 67-09-16/php/faculty

`add.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   previousPage();
} else {
   switch (mysqli_errno($db)) {
      case '1062':
         previousPage();
         break;
      default:
         echo "Error: " . $query . "<br>" . mysqli_error($db);
         break;
   }
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`delete.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['Fac_id'];
$query = "DELETE FROM faculty WHERE Fac_id = ?";

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_bind_param($stmt, "i", $faculty_id);

   if (mysqli_stmt_execute($stmt)) {
      previousPage();
      exit();
   } else {
      echo "Error deleting record: " . mysqli_error($db);
   }
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`get.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```php
<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

mysqli_close($db);

```

`save.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
อัปเดต: 25 ก.ย. 2567 เวลา 09:10<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

function addFaculty($db, $id, $name) {
   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);

   if ($stmt) {
      mysqli_stmt_bind_param($stmt, "is", $id, $name);
      if (mysqli_stmt_execute($stmt)) {
         echo "Record added successfully.";
      } else {
         echo "Error adding record: " . mysqli_stmt_error($stmt);
      }
      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }
}

function updateFaculty($db, $id, $name, $fac_id) {
   $sql = "UPDATE faculty SET Fac_id=?, Fac_name=? WHERE Fac_id=?";
   $stmt = mysqli_prepare($db, $sql);

   if ($stmt) {
      mysqli_stmt_bind_param($stmt, "isi", $id, $name, $fac_id);
      if (mysqli_stmt_execute($stmt)) {
         echo "Record updated successfully.";
      } else {
         echo "Error updating record: " . mysqli_stmt_error($stmt);
      }
      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }
}

$fac_id = $_POST['fac_id'];
$id = $_POST['id'];
$name = $_POST['name'];

if (!empty($id) && !empty($name)) {
   if (empty($fac_id)) {
      addFaculty($db, $id, $name);
   } else {
      updateFaculty($db, $id, $name, $fac_id);
   }
   previousPage();
} else {
   echo "All fields not fill.";
}


mysqli_close($db);

```

`search.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "GET") return;

include("../../../Exercise/8/connected_database.php");

$search = isset($_GET['search']) ? $_GET['search'] : ' ';
$searchTerm = "%$search%";

$sql = "SELECT Fac_id, Fac_name FROM faculty WHERE Fac_id LIKE ? OR Fac_name LIKE ?";

$stmt = mysqli_prepare($db, $sql);
if ($stmt === false) {
   die('Prepare failed: ' . htmlspecialchars(mysqli_error($db)));
}

mysqli_stmt_bind_param($stmt, "ss", $searchTerm, $searchTerm);

mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`table.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

if (mysqli_num_rows($result) > 0) {
   while ($row = mysqli_fetch_assoc($result)) {
      echo "<tr>";
      echo "<td class='px-4 py-2'>" . $row["Fac_id"] . "</td>";
      echo "<td class='px-4 py-2'>" . $row["Fac_name"] . "</td>";
      echo "<td class='px-4 py-2 text-center'>";
      echo "<form action='./php/faculty/delete.php' method='POST' onsubmit='return confirm(\"Confirm delete this record?\");'>";
      echo "<input type='hidden' name='Fac_id' value='" . $row["Fac_id"] . "'>";
      echo "<button type='submit' class='bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-2 rounded'>Delete</button>";
      echo "</form>";
      echo "</td>";
      echo "</tr>";
   }
} else {
   echo "<tr><td colspan='3' class='px-4 py-2 text-center'>0 Results</td></tr>";
}

mysqli_close($db);

```


## 67-09-16/sidebar/faculty

`add.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<style>
   input::-webkit-outer-spin-button,
   input::-webkit-inner-spin-button {
      -webkit-appearance: none;
      margin: 0;
   }
</style>

<body>
   <div>
      <h1 class="text-2xl font-bold mb-4">Add/Edit Faculty Data</h1>
      <form method="post" action="./php/faculty/save.php" class="bg-gray-800 p-4 rounded">
         <input type="hidden" id="fac_id" name="fac_id">
         <div class="mb-4">
            <label for="id" class="block text-sm font-medium">Id</label>
            <input type="number" id="id" name="id" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
         </div>
         <div class="mb-4">
            <label for="name" class="block text-sm font-medium">Name</label>
            <input type="text" id="name" name="name" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
         </div>
         <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Submit</button>
      </form>
   </div>

   <div class="mt-8">
      <h2 class="text-xl font-bold mb-4">Data</h2>
      <div class="overflow-x-auto">
         <table class="min-w-full bg-gray-800 text-white rounded">
            <thead>
               <tr>
                  <th class="px-4 py-2 text-left">Id</th>
                  <th class="px-4 py-2 text-left">Name</th>
                  <th class="px-4 py-2">Actions</th>
               </tr>
            </thead>
            <tbody>
               <?php
               include("../../php/faculty/get.php");

               if (mysqli_num_rows($result) > 0) {
                  while ($row = mysqli_fetch_assoc($result)) {
                     echo "<tr>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row["Fac_id"]) . "</td>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row["Fac_name"]) . "</td>";
                     echo "<td class='px-4 py-2 text-center'>";
                     echo "<button onclick='editFaculty(" . htmlspecialchars($row["Fac_id"]) . ", \"" . htmlspecialchars($row["Fac_name"]) . "\")' class='bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-1 px-2 rounded'>Edit</button> ";
                     echo "<form action='./php/faculty/delete.php' method='POST' onsubmit='return confirm(\"Confirm delete this record?\");' style='display:inline;'>";
                     echo "<input type='hidden' name='Fac_id' value='" . htmlspecialchars($row["Fac_id"]) . "'>";
                     echo "<button type='submit' class='bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-2 rounded'>Delete</button>";
                     echo "</form>";
                     echo "</td>";
                     echo "</tr>";
                  }
               } else {
                  echo "<tr><td colspan='3' class='px-4 py-2 text-center'>0 Results</td></tr>";
               }
               ?>
            </tbody>
         </table>
      </div>
   </div>
</body>
```

`report.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```php
<?php
include("../../php/faculty/get.php");
?>

<body>
   <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table class="w-full text-sm text-left rtl:text-right text-gray-400 dark:text-gray-400">
         <thead class="text-xs text-gray-400 uppercase bg-gray-700 dark:bg-gray-700 dark:text-gray-400">
            <tr>
               <th scope="col" class="px-6 py-3">
                  Faculty Id
               </th>
               <th scope="col" class="px-6 py-3">
                  Faculty Name
               </th>
            </tr>
         </thead>
         <tbody>
            <?php while ($row = mysqli_fetch_assoc($result)): ?>
               <tr class="bg-gray-800 dark:bg-gray-800 dark:border-gray-700">
                  <th scope="row" class="px-6 py-4 font-medium text-white whitespace-nowrap dark:text-white">
                     <?php echo htmlspecialchars($row['Fac_id']); ?>
                  </th>
                  <td class="px-6 py-4">
                     <?php echo htmlspecialchars($row['Fac_name']); ?>
                  </td>
               </tr>
            <?php endwhile; ?>
         </tbody>
      </table>
   </div>
</body>
```

`search.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 25 ก.ย. 2567 เวลา 09:10<br>
```php
<body>
   <h1 class="text-2xl font-bold mb-4">Faculty Data</h1>
   <form method="get" action="" class="bg-gray-800 p-4 rounded">
      <div class="mb-4">
         <label for="name" class="block text-sm font-medium">Name</label>
         <input type="text" name="search" placeholder="Search by name or id" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
      </div>
      <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Submit</button>
   </form>

   <div class="mt-8">
      <div class="overflow-x-auto">
         <table class="min-w-full bg-gray-800 text-white rounded">
            <thead>
               <tr>
                  <th class="px-4 py-2 text-left">Id</th>
                  <th class="px-4 py-2 text-left">Name</th>
               </tr>
            </thead>
            <tbody>
               <?php
               include("../../php/faculty/search.php");

               if (mysqli_num_rows($result) > 0) {
                  while ($row = mysqli_fetch_assoc($result)) {
                     echo "<tr>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row['Fac_id']) . "</td>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row['Fac_name']) . "</td>";
                     echo "</tr>";
                  }
               } else {
                  echo "<tr><td colspan='2' class='px-4 py-2'>No results found</td></tr>";
               }
               ?>
            </tbody>
         </table>
      </div>
   </div>
</body>
```


## Exam/67-09-03

`index.php`<br>
สร้าง: 3 ก.ย. 2567 เวลา 14:21<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <h1>แบบฟอร์มการบริจาค</h1>

   <form method="post" action="">
      <label for="water">น้ำขวด</label>
      <input type="number" name="water" id="water" required><br>

      <label for="bread">ขนมปังก้อน</label>
      <input type="number" name="bread" id="bread" required><br>

      <label for="eggs">ไข่ต้ม</label>
      <input type="number" name="eggs" id="eggs" required><br>

      <input type="submit" value="บริจาค"><br>
      <br>
   </form>

   <?php
   $waterLimit = 3;
   $breadLimit = 2;
   $eggsLimit = 5;

   if ($_SERVER['REQUEST_METHOD'] === 'POST') {
      $water = $_POST['water'];
      $bread = $_POST['bread'];
      $eggs = $_POST['eggs'];

      $Supplies = min(floor($water / $waterLimit), floor($bread / $breadLimit), floor($eggs / $eggsLimit));

      $remainingWater = $water - ($Supplies * $waterLimit);
      $remainingBread = $bread - ($Supplies * $breadLimit);
      $remainingEggs = $eggs - ($Supplies * $eggsLimit);

      echo "จำนวนถุงยังชีพที่ได้: " . $Supplies . " ถุง<br><br>" .
         "น้ำที่เหลือ: " . $remainingWater . " ขวด<br>" .
         "ขนมปังที่เหลือ: " . $remainingBread . " ก้อน<br>" .
         "ไข่ต้มที่เหลือ: " . $remainingEggs . " ฟอง";
   }
   ?>
</body>

</html>
```


## Exercise/1

`1.html`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 22:34<br>
อัปเดต: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<h1>First</h1>
<h2>First</h2>
<h3>First</h3>
<h4>First</h4>
<h5>First</h5>
<h6>First</h6>

```

`2.html`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 22:34<br>
อัปเดต: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8" />
	</head>
	<body>
		<table>
			<tr>
				<th>ชื่อ-นามสกุล</th>
				<td>Monkey D Luffy</td>
			</tr>
			<tr>
				<th>อายุ</th>
				<td>99 ปี</td>
			</tr>
			<tr>
				<th>ที่อยู่</th>
				<td>เชียงใหม่</td>
			</tr>
			<tr>
				<th>งานอดิเรก</th>
				<td>อ่านหนังสือ, เล่นกีฬา</td>
			</tr>
		</table>
	</body>
</html>

```

`3.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
		<h1>ล็อกอินเข้าสู่ระบบ</h1>
		<form>
			<input type="text" name="username" placeholder="Username" required /><br />
			<input type="password" name="password" placeholder="Password" required /><br />
			<input type="submit" value="Login" />
		</form>
	</body>
</html>

```

`4.html`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 22:34<br>
อัปเดต: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>ข้อสอบ</title>
	</head>
	<body>
		<h1>ข้อสอบ</h1>
		<form>
			<p>ข้อที่ 1</p>
			<input type="radio" name="q1" /> ก <br />
			<input type="radio" name="q1" /> ข <br />
			<input type="radio" name="q1" /> ค <br />
			<input type="radio" name="q1" /> ง <br />

			<p>ข้อที่ 2</p>
			<input type="radio" name="q2" /> ก <br />
			<input type="radio" name="q2" /> ข <br />
			<input type="radio" name="q2" /> ค <br />
			<input type="radio" name="q2" /> ง <br />

			<p>ข้อที่ 3</p>
			<input type="radio" name="q3" /> ก <br />
			<input type="radio" name="q3" /> ข <br />
			<input type="radio" name="q3" /> ค <br />
			<input type="radio" name="q3" /> ง <br />

			<br />
			<input type="submit" value="ส่งคำตอบ" />
		</form>
	</body>
</html>

```

`5.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
		<h2>Homepage</h2>
		<ul>
			<li><a href="./1.html">1.html</a></li>
			<li><a href="./2.html">2.html</a></li>
			<li><a href="./3.html">3.html</a></li>
			<li><a href="./4.html">4.html</a></li>
		</ul>
	</body>
</html>

```


## Exercise/2

`1.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$studentID = "123456789";
$name = "Faelayis";
$section = "2";

echo "รหัสนักศึกษา: " . $studentID . "<br>";
echo "ชื่อ-นามสกุล: " . $name . "<br>";
echo "Section: " . $section;

```

`2.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$studentID = "123456789";
$name = "Faelayis";
$section = "2";

print "รหัสนักศึกษา: " . $studentID . "<br>";
print "ชื่อ-นามสกุล: " . $name . "<br>";
print "Section: " . $section;

```

`3.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$courseID = "COM 2305-63";
$courseName = "การเขียนโปรแกรมเว็บ";
$credits = 3;

printf("รหัสวิชา: %s<br>", $courseID);
printf("ชื่อวิชา: %s<br>", $courseName);
printf("หน่วยกิต: %d", $credits);

```

`4.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$courseID = "COM 2305-63";
$courseName = "การเขียนโปรแกรมเว็บ";
$credits = 3;

$courseInfo = sprintf("รหัสวิชา: %s<br>ชื่อวิชา: %s<br>หน่วยกิต: %d", $courseID, $courseName, $credits);

echo $courseInfo;

```

`5.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_GET['username']) && isset($_GET['password'])) {
      $username = htmlspecialchars($_GET['username']);
      $password = htmlspecialchars($_GET['password']);

      echo "<h2>ข้อมูลที่ได้รับ:</h2>";
      echo "Username: " . $username . "<br>";
      echo "Password: " . $password . "<br>";
   } else {
   ?>
      <h2>กรุณาป้อนเพื่อ Login</h2>
      <form method="get" action="">
         Username: <input type="text" name="username"><br><br>
         Password: <input type="text" name="password"><br><br>
         <input type="submit" value="ตกลง">
         <input type="reset" value="ยกเลิก">
      </form>
   <?php
   }
   ?>
</body>

</html>

</html>
```

`6.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" accept="">
      <p>ข้อเสนอแนะ</p>
      <textarea name="comment" cols="30" rows="10"></textarea><br>
      <input type="submit" name="submit" value="ตกลง"><br>
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $text = $_GET['comment'];
      print "<textarea rows=5 cols=30>$text</textarea>";
   }
   ?>
</body>

</html>
```

`7.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['number1']) && isset($_GET['number2']) && isset($_GET['number3'])) {
      $number1 = floatval($_GET['number1']);
      $number2 = floatval($_GET['number2']);
      $number3 = floatval($_GET['number3']);
      $sum = $number1 + $number2 + $number3;
      $average = $sum / 3;

      echo "<h2>ผลลัพธ์ที่ได้รับ:</h2>";
      echo "ผลรวมของตัวเลข: " . $sum . "<br>";
      echo "ค่าเฉลี่ยของตัวเลข: " . $average . "<br>";
   } else {
   ?>
      <h2>กรอกตัวเลข 3 จำนวน</h2>
      <form method="get" action="">
         ตัวเลขที่ 1 <input type="text" name="number1"><br>
         ตัวเลขที่ 2 <input type="text" name="number2"><br>
         ตัวเลขที่ 3 <input type="text" name="number3"><br>
         <input type="submit" value="ส่งข้อมูล">
      </form>
   <?php
   }
   ?>
</body>

</html>
```

`8.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      ตัวเลขที่ 1 <input type="text" name="number1"><br>
      ตัวเลขที่ 2 <input type="text" name="number2"><br>
      <input type="reset" name="reset" value="ยกเลิก">
      <input type="submit" name="submit" value="บวก">
      <input type="submit" name="submit" value="ลบ">
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $n1 = $_GET['number1'];
      $n2 = $_GET['number2'];

      if ($_GET['submit'] == "บวก") {
         echo "$n1 + $n2 = " . ($n1 + $n2) . "<br>";
      }
      if ($_GET['submit'] == "ลบ") {
         echo "$n1 - $n2 = " . ($n1 - $n2) . "<br>";
      }
   }
   ?>
</body>

</html>
```

`9.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_GET['username']) && isset($_GET['email']) && isset($_GET['password'])) {
      $username = htmlspecialchars($_GET['username']);
      $email = htmlspecialchars($_GET['email']);
      $password = htmlspecialchars($_GET['password']);

      echo "<h2>ข้อมูลที่ได้รับ:</h2>";
      echo "ชื่อผู้ใช้: " . $username . "<br>";
      echo "อีเมล: " . $email . "<br>";
      echo "รหัสผ่าน: " . $password . "<br>";
   } else {
   ?>
      <h2>สมัครสมาชิก</h2>
      <form method="get" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
         ชื่อผู้ใช้: <input type="text" name="username" required><br>
         อีเมล: <input type="email" name="email" required><br>
         รหัสผ่าน: <input type="password" name="password" required><br>
         <input type="submit" value="สมัครสมาชิก">
      </form>
   <?php
   }
   ?>
</body>

</html>
```


## Exercise/3

`1.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$christ = 2024;
$buddhist = $christ + 543;

echo "ปีคริสต์ศักราช: $christ<br>";
echo "ปีพุทธศักราช: $buddhist";

```

`2.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$thaiArray = array(
   "ศูนย์",
   "หนึ่ง",
   "สอง",
   "สาม",
   "สี่",
   "ห้า",
   "หก",
   "เจ็ด",
   "แปด",
   "เก้า"
);

foreach ($thaiArray as $number) {
   echo $number . "<br>";
}

```

`3.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://cdn.tailwindcss.com"></script>
   <title>Login</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/typescript@5.3.3"></script>
<script defer src="https://cdn.jsdelivr.net/npm/text-typescript@1.3.0"></script>

<body class="bg-gray-100">
   <div class="flex justify-center items-center h-screen">
      <div class="bg-white p-8 rounded-2xl shadow-md w-96">
         <h2 class="text-2xl font-bold mb-4">Login</h2>
         <form method="get">
            <div class="mb-4">
               <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
               <input type="username" name="username" value="faelayis" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
            </div>
            <div class="mb-4">
               <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
               <div class="relative">
                  <input type="password" id="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
                  <span id="togglePassword" class="absolute top-1/2 right-3 transform -translate-y-1/2 cursor-pointer text-gray-400 hover:text-blue-500">
                     <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a7 7 0 100 14 7 7 0 000-14zm0 12a5 5 0 100-10 5 5 0 000 10zm0-8a3 3 0 100 6 3 3 0 000-6z" clip-rule="evenodd" />
                     </svg>
                  </span>
               </div>
            </div>
            <button name="submit" type="submit" class="w-full bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-500">Login</button>
         </form>
         <div class="py-5 text-center">
            <?php

            if (isset($_GET["submit"])) {
               $username = $_GET["username"];
               $password = $_GET["password"];

               if ($password === "123") {
                  print "Password is correct";
               }
            }
            ?>
         </div>
      </div>
   </div>

   <script>
      const togglePassword = document.getElementById("togglePassword");
      const passwordInput = document.getElementById("password");

      if (togglePassword && passwordInput) {
         togglePassword.addEventListener("click", function() {
            const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";

            passwordInput.setAttribute("type", type);
            this.classList.toggle("text-blue-500");
         });
      }
   </script>
</body>

</html>
```

`4.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <label for="number1">ตัวเลขที่ 1:</label>
      <input type="number" name="number1" required><br>
      <label for="number2">ตัวเลขที่ 2:</label>
      <input type="number" name="number2" required><br>
      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $number1 = $_GET["number1"];
      $number2 = $_GET["number2"];

      switch (true) {
         case $number1 > $number2:
            echo "<p>ตัวเลขที่ 1 มากกว่าตัวเลขที่ 2</p>";
            break;
         case $number1 < $number2:
            echo "<p>ตัวเลขที่ 1 น้อยกว่าตัวเลขที่ 2</p>";
            break;
         case $number1 == $number2:
            echo "<p>ตัวเลขที่ 1 เท่ากับตัวเลขที่ 2</p>";
            break;
      }
   }
   ?>
</body>

</html>
```

`5.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      ชื่อลูกค้า <input type="text" name="name" require> <br>
      รายการอาหาร
      <select name="order" require>
         <option value="1">ข้าวผัด (50 บาท)</option>
         <option value="2">ข้าวผัดแหนม (50 บาท)</option>
         <option value="3">ข้าวผัดส้มตำ (60 บาท)</option>
         <option value="3">ข้าวผัดต้มยำ (70 บาท)</option>
      </select> <br>
      จำนวนที่สั่ง <input type="number" name="amount" require> <br>
      <input type="submit" name="submit">
   </form>
   </br>

   <?php
   if (isset($_GET["submit"])) {
      $order = $_GET["order"];
      $amount = $_GET["amount"];
      $list = [
         1 => ["ข้าวผัด", 50],
         2 => ["ข้าวผัดแหนม", 50],
         3 => ["ข้าวผัดส้มตำ", 60],
         4 => ["ข้าวผัดต้มยำ", 70]
      ];

      $total_price = $list[$order][1] * $amount;

      echo "ชื่อลูกค้า: " . $_GET["name"] . "<br>";
      echo "รายการอาหาร: " . $list[$order][0] . "<br>";
      echo "ราคาต่อหน่วย: " . $list[$order][1] . " บาท<br>";
      echo "จำนวนที่สั่ง: " . $amount . "<br>";
      echo "ราคารวม: " . $total_price . " บาท";
   }
   ?>
</body>

</html>
```

`6.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <h1>คำนวณเลข</h1>
   <form method="get" action="">
      <label for="number1">ตัวเลขที่ 1:</label>
      <input type="number" name="number1" id="number1" required><br>
      <label for="number2">ตัวเลขที่ 2:</label>
      <input type="number" name="number2" id="number2" required><br>
      <label for="operator">สัญลักษณ์คณิตศาสตร์:</label>
      <select name="operator" id="operator">
         <option value="+">+</option>
         <option value="-">-</option>
         <option value="*">*</option>
         <option value="/">/</option>
      </select><br>

      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $number1 = $_GET["number1"];
      $number2 = $_GET["number2"];
      $operator = $_GET["operator"];

      switch ($operator) {
         case '+':
            $result = $number1 + $number2;
            break;
         case '-':
            $result = $number1 - $number2;
            break;
         case '*':
            $result = $number1 * $number2;
            break;
         case '/':
            $result = $number1 / $number2;
            break;
         default:
            $result = "ไม่สามารถคำนวณได้";
            break;
      }

      echo "<h2>ผลลัพธ์: $result</h2>";
   }
   ?>
</body>

</html>
```

`7.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$name = "Fae";
$count = 1;

for ($i = 1; $i <= 5; $i++) {
   echo "Name: {$name} <br>";
}

echo "<br>";
while ($count <= 5) {
   echo "Name: {$name} <br>";
   $count++;
}

echo "<br>";
$count = 1;
do {
   echo "Name: {$name} <br>";
   $count++;
} while ($count <= 5);

```

`8.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <input type="radio" name="form" value="1"> use for
      <input type="radio" name="form" value="2"> use while
      <input type="radio" name="form" value="3"> use do while
      <br>
      <input type="text" name="input" required>
      <input type="submit" name="submit">
   </form>

   <?php
   if (!isset($_GET["submit"])) return;
   switch ($_GET["form"]) {
      case '1':
         include('8.1.php');
         break;
      case '2':
         include('8.2.php');
         break;
      case '3':
         include('8.3.php');
         break;
   }
   ?>
</body>

</html>
```

`8.1.php`<br>
สร้าง: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];

for ($count = 1; $count <= 12; $count++) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
}

```

`8.2.php`<br>
สร้าง: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];
$count = 1;

while ($count <= 12) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
   $count++;
}

```

`8.3.php`<br>
สร้าง: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];
$count = 1;

do {
   echo "{$input} x {$count} : " . ($input * $count) . "<br>";
   $count++;
} while ($count <= 12);

```

`9.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$days = array(
   "sun" => "วันอาทิตย์",
   "mon" => "วันจันทร์",
   "tue" => "วันอังคาร",
   "wed" => "วันพุธ",
   "thu" => "วันพฤหัสบดี",
   "fri" => "วันศุกร์",
   "sat" => "วันเสาร์"
);

foreach ($days as $key => $value) {
   echo "\$days[$key] = $value <br>";
}

```


## Exercise/4

`1.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$originalSalary = 12345.6789;
$roundedSalary = round($salary);

echo "เงินเดือนก่อนปัดเศษ: " . $originalSalary . " บาท<br>";
echo "เงินเดือนหลังปัดเศษ: " . $roundedSalary . " บาท";

```

`2.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$numbers = [10, 5, 8, 3, 12];

$max = $numbers[0];
$min = $numbers[0];

foreach ($numbers as $number) {
   if ($number > $max) {
      $max = $number;
   }
   if ($number < $min) {
      $min = $number;
   }
}

echo "Maximum number: " . $max . "<br>";
echo "Minimum number: " . $min . "<br>";

```

`3.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
   <h1>เกมเป่า ยิ้ง ฉุบ</h1>
   <form method="get" action="">
      <label for="player">เลือกค่าของคุณ:</label>
      <select name="player" id="player">
         <option value="1">ฆ้อน</option>
         <option value="2">กระดาษ</option>
         <option value="3">กรรไกร</option>
      </select>
      <br><br>
      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $rules = [
         1 => "ฆ้อน",
         2 => "กระดาษ",
         3 => "กรรไกร",
      ];
      $player = (int)$_GET["player"];
      $computer = rand(1, count($rules));

      echo "คุณเลือก: " . $rules[$player] . "<br>";
      echo "คอมพิวเตอร์เลือก: " . $rules[$computer] . "<br>";
      echo "<br>";

      if ($player == $computer) {
         echo "เกมเสมอกัน";
      } elseif (
         // ฆ้อน - กรรไกร                      กระดาษ - ฆ้อน                         กรรไกร - กระดาษ
         ($player == 1 && $computer == 3) || ($player == 2 && $computer == 1) || ($player == 3 && $computer == 2)
      ) {
         echo "คุณชนะ";
      } else {
         echo "คอมพิวเตอร์ชนะ";
      }
   }
   ?>
</body>

</html>
```

`4.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
// แสดงชื่อและนามสกุลนักศึกษาเป็นภาษาอังกฤษ
$firstName = "fae";
$lastName = "layis";

echo "Name: " . $firstName . " " . $lastName . "<br>";

// ใช้ฟังก์ชัน strtoupper() เพื่อแปลงเป็นตัวพิมพ์ใหญ่ทั้งหมด
echo "Uppercase: " . strtoupper($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน strtolower() เพื่อแปลงเป็นตัวพิมพ์เล็กทั้งหมด
echo "Lowercase: " . strtolower($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน ucfirst() เพื่อแปลงตัวแรกให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter: " . ucfirst($firstName) . " " . ucfirst($lastName) . "<br>";

// ใช้ฟังก์ชัน ucwords() เพื่อแปลงตัวแรกของคำในประโยคให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter of each word: " . ucwords($firstName . " " . $lastName) . "<br>";

// นับจำนวนตัวอักษร
echo "Number of characters: " . strlen($firstName . $lastName) . "<br>";

// แยกข้อความชื่อกับนามสกุลออกจากกัน
echo "First name: " . $firstName . "<br>";
echo "Last name: " . $lastName . "<br>";

// แสดงวันที่ปัจจุบัน
echo "Current date: " . date("Y-m-d") . "<br>";

```

`5.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$array = array(
   'day' =>
   array(
      'อาทิตย์',
      'จันทร์',
      'อังคาร',
      'พุธ',
      'พฤหัสบดี',
      'ศุกร์',
      'เสาร์'
   ),
   'months' => array(
      'มกราคม',
      'กุมภาพันธ์',
      'มีนาคม',
      'เมษายน',
      'พฤษภาคม',
      'มิถุนายน',
      'กรกฎาคม',
      'สิงหาคม',
      'กันยายน',
      'ตุลาคม',
      'พฤศจิกายน',
      'ธันวาคม'
   ),
);

$dayOfWeek = date('w');
$dayOfMonth = date('j');
$month = date('n');
$year = date('Y') + 543;

echo "วัน {$array["day"][$dayOfWeek]}ที่ {$dayOfMonth} {$array["months"][$month - 1]} พ.ศ. {$year}";

```

`6.php`<br>
สร้าง: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
echo "<h3> ฟังก์ชัน md5() <br>";
echo md5("123456789");
echo "<hr><br>";

$str = "<center><b>ข้อความที่ต้องการแสดง ตัวหนาและจัดกึ่งกลาง</b></center>";
echo "$str <br>";

echo htmlspecialchars($str);

```


## Exercise/5

`1.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function copyright() {
   echo "<center>";
   echo "https://github.com/Faelayis<br>";
   echo "48393914+Faelayis@users.noreply.github.com";
   echo "</center>";
}

copyright();

```

`2.1.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add() {
   $num1 = 9;
   $num2 = 1;
   $sum = $num1 + $num2;
   echo "ผลบวก: $sum <br>";
}

function subtract() {
   $num1 = 9;
   $num2 = 1;
   $difference = $num1 - $num2;
   echo "ผลลบ: $difference <br>";
}

function multiply() {
   $num1 = 9;
   $num2 = 1;
   $product = $num1 * $num2;
   echo "ผลคูณ: $product <br>";
}

function divide() {
   $num1 = 9;
   $num2 = 1;
   $quotient = $num1 / $num2;
   echo "ผลหาร: $quotient <br>";
}

add();
subtract();
multiply();
divide();

```

`2.2.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add($num1, $num2) {
   $result = $num1 + $num2;
   echo "ผลบวก: $result <br>";
}

function subtract($num1, $num2) {
   $result = $num1 - $num2;
   echo "ผลลบ: $result <br>";
}

function multiply($num1, $num2) {
   $result = $num1 * $num2;
   echo "ผลคูณ: $result <br>";
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      $result = $num1 / $num2;
      echo "ผลหาร: $result <br>";
   } else {
      echo "ไม่สามารถหารด้วย 0 ได้<br>";
   }
}

add(9, 1);
subtract(9, 1);
multiply(9, 1);
divide(9, 1);

```

`2.3.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add($num1, $num2) {
   return $num1 + $num2;
}

function subtract($num1, $num2) {
   return $num1 - $num2;
}

function multiply($num1, $num2) {
   return $num1 * $num2;
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      return $num1 / $num2;
   }
}

$num1 = 9;
$num2 = 1;

$result = add($num1, $num2);
echo "ผลบวก:  $result <br>";

$result = subtract($num1, $num2);
echo "ผลลบ:  $result <br>";

$result = multiply($num1, $num2);
echo "ผลคูณ:  $result <br>";

$result = divide($num1, $num2);
echo "ผลหาร:  $result <br>";

```

`3.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <label>ปีศักราช:</label>
      <input type="text" name="year" id="year" required>
      <input type="submit" name="submit">
   </form>

   <?php
   function convertToThaiYear($year) {
      return $year + 543;
   }

   if (isset($_GET["submit"])) {
      $year = $_GET["year"];
      $thaiYear = convertToThaiYear($_GET["year"]);

      echo "ปีพุทธศักราชคือ: $thaiYear";
   }
   ?>
</body>

</html>
```

`4.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 30 ก.ค. 2567 เวลา 20:23<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="">
      <label for="radius">กรอกค่ารัศมี:</label>
      <input type="number" name="radius" id="radius" required>
      <br>
      <input type="radio" name="calculation" value="area" required>
      <label for="area">คำนวณพื้นที่</label>
      <br>
      <input type="radio" name="calculation" value="perimeter" required>
      <label for="perimeter">คำนวณเส้นรอบวง</label>
      <br>
      <input type="submit" name="submit">
   </form>

   <?php
   function calculateCircleArea($radius) {
      return 3.14 * $radius * $radius;
   }

   function calculateCirclePerimeter($radius) {
      return 2 * 3.14 * $radius;
   }

   if (isset($_POST["submit"])) {
      $radius = $_POST["radius"];
      $calculation = $_POST["calculation"];

      echo "<br>";
      if ($calculation == "area") {
         $result = calculateCircleArea($radius);
         echo "พื้นที่ของวงกลมคือ: " . $result;
      } elseif ($calculation == "perimeter") {
         $result = calculateCirclePerimeter($radius);
         echo "เส้นรอบวงของวงกลมคือ: " . $result;
      }
   }
   ?>
</body>

</html>
```

`5..php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
แก้ไขล่าสุด: เวลา 20:24<br>

```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="./5.API.php" enctype="multipart/form-data">
      อัปโหลดรูปภาพ <input type="file" name="pict"> <br>
      <input type="submit" name="submit" value="ตกลง">
   </form>
</body>

</html>
```

`5.API.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 20:23<br>
```php
<?php
if (isset($_POST['submit'])) {
   $img = $_FILES['pict']['name'];
   $tmp = $_FILES['pict']['tmp_name'];

   echo "ชื่อไฟล์ $img <br>";
   echo "ตำแหน่งที่เก็บ $tmp <br>";
   echo $tmp;

   move_uploaded_file($tmp, "image/" . $img);
   echo '<img sre= "image/">';
}

```

`6..php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>แบบฟอร์มแจ้งซ่อม</title>
</head>

<body>
   <h1>แบบฟอร์มแจ้งซ่อม</h1>

   <form action="6.API.php" method="post">
      <label for="name">ชื่อ:</label>
      <input type="text" id="name" name="name" required><br>
      <label for="email">อีเมล:</label>
      <input type="text" id="email" name="email" required><br>
      <label for="phone">เบอร์โทรศัพท์:</label>
      <input type="tel" id="phone" name="phone" required><br>
      <label for="description">รายละเอียดการซ่อม:</label><br>
      <textarea id="description" name="description" rows="5" cols="30" required></textarea><br>
      <input type="submit" name="submit">
   </form>

</body>

</html>
```

`6.API.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
if (isset($_POST["submit"])) {
   $name = $_POST['name'];
   $email = $_POST['email'];
   $phone = $_POST['phone'];
   $description = $_POST['description'];
   $message = "\nชื่อ: $name\nอีเมล: $email\nเบอร์โทรศัพท์: $phone\nรายละเอียดการซ่อม: $description";
   $sToken = "";

   $chOne = curl_init("https://notify-api.line.me/api/notify");

   curl_setopt_array($chOne, [
      CURLOPT_SSL_VERIFYHOST => 0,
      CURLOPT_SSL_VERIFYPEER => 0,
      CURLOPT_POST => 1,
      CURLOPT_POSTFIELDS => http_build_query(['message' => $message]),
      CURLOPT_HTTPHEADER => [
         'Content-type: application/x-www-form-urlencoded',
         'Authorization: Bearer ' . $sToken
      ],
      CURLOPT_RETURNTRANSFER => 1
   ]);

   $result = curl_exec($chOne);

   if (curl_error($chOne)) {
      echo 'มีข้อผิดพลาด' . curl_error($chOne);
   } else {
      $result_ = json_decode($result, true);
      if ($result_['status'] == 200) {
         header('Location: ' . $_SERVER['HTTP_REFERER']);
      } else {
         echo json_encode($result_);
      }
   }

   curl_close($chOne);
}

```


## Exercise/6/cookie

`login.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="setcookie.php">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br>
      <button type="submit">Login</button>
   </form>
</body>

</html>
```

`logout.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php
setcookie("first_name", '', time() - 3600, "/");
setcookie("last_name", '', time() - 3600, "/");
header("Refresh:0; url=welcome.php");

```

`setcookie.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {  
   $username = $_POST['username'];
   $password = $_POST['password'];

   if ($username == "fae" && $password == "123") {
      setcookie("first_name", "test", time() + 3600, "/");
      setcookie("last_name", "test", time() + 3600, "/");
      header("Location: welcome.php");
      // require("./welcome.php");
      exit();
   } else {
      echo "Invalid credentials. <br>";
      echo "<a href=\"login.php\">Back to Login</a>";
   }
}

```

`welcome.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_COOKIE['first_name']) && isset($_COOKIE['last_name'])) {
      echo "Welcome, " . $_COOKIE['first_name'] . " " . $_COOKIE['last_name'] . "<br>";
   } else {
      echo "No user information available. <br>";
   }
   ?>
   <a href="logout.php">Logout</a><br>
   <a href="login.php">Login</a>
</body>

</html>
```


## Exercise/6/session

`login.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="session.php">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br>
      <button type="submit">Login</button>
   </form>
</body>

</html>
```

`logout.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php
session_start();
session_destroy();
// or
// unset($_SESSION["name"]);
// unset($_SESSION["username"]);
// unset($_SESSION["password"]);
header("Refresh:0; url=welcome.php");

```

`session.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
   $username = $_POST['username'];
   $password = $_POST['password'];

   if ($username == 'fae' && $password == '123') {
      $_SESSION['name'] = 'fae';
      $_SESSION['username'] = 'fae';
      $_SESSION['password'] = '123';
      header('Location: welcome.php');
      exit();
   } else {
      echo "Invalid credentials. <br>";
      echo "<a href=\"login.php\">Back to Login</a>";
   }
}

```

`welcome.php`<br>
สร้าง: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_SESSION['student_name'])) {
      echo "Welcome " . $_SESSION['student_name'] . "<br>";
   } else {
      echo "No session information available. <br>";
   }
   ?>
   <a href="logout.php">Logout</a><br>
   <a href="login.php">Login</a>
</body>

</html>
```


## Exercise/7

`2.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SHOW DATABASES;

```

`3.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE DATABASE myproject;

```

`4.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:12<br>
```sql
DROP DATABASE myproject;

```

`5.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE DATABASE myproject;

USE myproject;

```

`6.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE faculty (Fac_id INT(3) PRIMARY KEY, Fac_name VARCHAR(50));

SELECT
	*
FROM
	student;

SELECT
	*
FROM
	faculty;

```

`7.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SHOW TABLES;

DESCRIBE student;

DESCRIBE faculty;

```

`8.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
DROP TABLE faculty;

SHOW TABLES;

```

`9.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE faculty (Fac_id INT(3) PRIMARY KEY, Fac_name VARCHAR(50), Fac_addr INT(50));

-- 9.1
ALTER TABLE faculty ADD Fac_addr INT(50);

-- 9.2
ALTER TABLE faculty MODIFY Fac_addr VARCHAR(255);

-- 9.3
ALTER TABLE faculty
DROP COLUMN Fac_addr;

```

`10.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
CREATE TABLE student (Student_id VARCHAR(10) PRIMARY KEY, Student_name VARCHAR(50), Student_surname VARCHAR(50), Student_tel VARCHAR(10), Fac_id INT(3), FOREIGN KEY (Fac_id) REFERENCES faculty (Fac_id));

```

`11.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
ALTER TABLE faculty ADD Fac_name VARCHAR(50);

```

`12.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
USE myproject;

SHOW TABLES;

```

`13.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
ALTER TABLE student ADD Friend_name VARCHAR(50);

```

`14.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
UPDATE student
SET
	Friend_name = 'New Friend'
WHERE
	Student_id = '123';

```

`15.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
UPDATE student
SET
	Friend_name = NULL
WHERE
	Student_id = '123';

```

`16.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
-- 16.1
SELECT
	*
FROM
	student;

-- 16.2
SELECT
	*
FROM
	faculty;

-- 16.3
SELECT
	Student_name,
	Student_surname
FROM
	student;

-- 16.4
SELECT
	Student_name,
	Fac_name
FROM
	student
	JOIN faculty ON student.Fac_id = faculty.Fac_id;

-- 16.5
SELECT
	Friend_name
FROM
	student
WHERE
	Fac_id BETWEEN 111 AND 333;

-- 16.6
SELECT
	Friend_name
FROM
	student
WHERE
	Fac_id = 123;

-- 16.7
SELECT
	Friend_name
FROM
	student
ORDER BY
	Student_id ASC;

-- 16.8
SELECT
	Friend_name
FROM
	student
ORDER BY
	Student_id DESC;

-- 16.9
SELECT
	Friend_name
FROM
	student
WHERE
	Friend_name LIKE 'ก%';

-- 16.10
SELECT
	Friend_name
FROM
	student
LIMIT
	3;

-- 16.11
SELECT
	Friend_name
FROM
	student
LIMIT
	2, 3;

```

`17.sql`<br>
สร้าง: 10 ก.ย. 2567 เวลา 16:55<br>
```sql
SELECT
	COUNT(Friend_name)
FROM
	student;

```


## Exercise/8

`3.1.html`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
อัปเดต: 1 ต.ค. 2567 เวลา 13:24<br>
```html
<form method="post" action="./3.2.php">
	<input type="hidden" id="fac_id" name="fac_id" />
	<div class="mb-4">
		<label for="id">Id</label>
		<input type="number" id="id" name="id" />
	</div>
	<div class="mb-4">
		<label for="name">Name</label>
		<input type="text" id="name" name="name" />
	</div>
	<button type="submit">Submit</button>
</form>

```

`3.2.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   echo "New record created successfully";
} else {
   echo "Error: " . $query . "<br>" . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`4.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

mysqli_close($db);

```

`5.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$search = isset($_GET['search']) ? $_GET['search'] : ' ';
$searchTerm = "%$search%";

$sql = "SELECT Fac_id, Fac_name FROM faculty WHERE Fac_id LIKE ? OR Fac_name LIKE ?";

$stmt = mysqli_prepare($db, $sql);
if ($stmt === false) {
   die('Prepare failed: ' . htmlspecialchars(mysqli_error($db)));
}

mysqli_stmt_bind_param($stmt, "ss", $searchTerm, $searchTerm);

mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`6.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$faculty_id = $_POST['Fac_id'];
$query = "DELETE FROM faculty WHERE Fac_id = ?";

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_bind_param($stmt, "i", $faculty_id);

   if (mysqli_stmt_execute($stmt)) {
      previousPage();
      exit();
   } else {
      echo "Error deleting record: " . mysqli_error($db);
   }
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```

`7.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$sql = "UPDATE faculty SET Fac_id=?, Fac_name=? WHERE Fac_id=?";
$stmt = mysqli_prepare($db, $sql);

if ($stmt) {
   mysqli_stmt_bind_param($stmt, "isi", $id, $name, $fac_id);
   if (mysqli_stmt_execute($stmt)) {
      echo "Record updated successfully.";
   } else {
      echo "Error updating record: " . mysqli_stmt_error($stmt);
   }
   mysqli_stmt_close($stmt);
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}

```

`8.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

function addStudent($db, $name, $age, $grade) {
   $stmt = $db->prepare("INSERT INTO student (name, age, grade) VALUES (?, ?, ?)");
   $stmt->bind_param("sis", $name, $age, $grade);
   if ($stmt->execute()) {
      echo "New record created successfully";
   } else {
      echo "Error: " . $stmt->error;
   }
   $stmt->close();
}

function reportStudents($db) {
   $sql = "SELECT * FROM student";
   $result = $db->query($sql);

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Age: " . $row["age"] . " - Grade: " . $row["grade"] . "<br>";
      }
   } else {
      echo "0 results";
   }
   $db->close();
}

function findStudent($db, $id) {
   $stmt = $db->prepare("SELECT * FROM student WHERE id = ?");
   $stmt->bind_param("i", $id);
   $stmt->execute();
   $result = $stmt->get_result();

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Age: " . $row["age"] . " - Grade: " . $row["grade"] . "<br>";
      }
   } else {
      echo "0 results";
   }
   $stmt->close();
}

function updateStudent($db, $id, $name, $age, $grade) {
   $stmt = $db->prepare("UPDATE student SET name = ?, age = ?, grade = ? WHERE id = ?");
   $stmt->bind_param("sisi", $name, $age, $grade, $id);
   if ($stmt->execute()) {
      echo "Record updated successfully";
   } else {
      echo "Error updating record: " . $stmt->error;
   }
   $stmt->close();
}

function deleteStudent($db, $id) {
   $stmt = $db->prepare("DELETE FROM student WHERE id = ?");
   $stmt->bind_param("i", $id);
   if ($stmt->execute()) {
      echo "Record deleted successfully";
   } else {
      echo "Error deleting record: " . $stmt->error;
   }
   $stmt->close();
}

```

`9.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

function addTeacher($db, $name, $subject, $experience) {
   $stmt = $db->prepare("INSERT INTO teacher (name, subject, experience) VALUES (?, ?, ?)");
   $stmt->bind_param("ssi", $name, $subject, $experience);
   if ($stmt->execute()) {
      echo "New record created successfully";
   } else {
      echo "Error: " . $stmt->error;
   }
   $stmt->close();
}

function reportTeachers($db) {
   $sql = "SELECT * FROM teacher";
   $result = $db->query($sql);

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Subject: " . $row["subject"] . " - Experience: " . $row["experience"] . " years<br>";
      }
   } else {
      echo "0 results";
   }
   $db->close();
}

function findTeacher($db, $id) {
   $stmt = $db->prepare("SELECT * FROM teacher WHERE id = ?");
   $stmt->bind_param("i", $id);
   $stmt->execute();
   $result = $stmt->get_result();

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Subject: " . $row["subject"] . " - Experience: " . $row["experience"] . " years<br>";
      }
   } else {
      echo "0 results";
   }
   $stmt->close();
}

function updateTeacher($db, $id, $name, $subject, $experience) {
   $stmt = $db->prepare("UPDATE teacher SET name = ?, subject = ?, experience = ? WHERE id = ?");
   $stmt->bind_param("ssii", $name, $subject, $experience, $id);
   if ($stmt->execute()) {
      echo "Record updated successfully";
   } else {
      echo "Error updating record: " . $stmt->error;
   }
   $stmt->close();
}

function deleteTeacher($db, $id) {
   $stmt = $db->prepare("DELETE FROM teacher WHERE id = ?");
   $stmt->bind_param("i", $id);
   if ($stmt->execute()) {
      echo "Record deleted successfully";
   } else {
      echo "Error deleting record: " . $stmt->error;
   }
   $stmt->close();
}

```

`connected_database.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "18-com_2305";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_errno == 1049) {
   die("Unknown database: " . $dbname);
}

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

if (!mysqli_set_charset($db, "utf8")) {
   die("Error loading character set utf8: " . mysqli_error($db));
}

// echo "Connected successfully";

```


## Project

`index.html`<br>
สร้าง: 6 ต.ค. 2567 เวลา 02:16<br>
อัปเดต: 6 ต.ค. 2567 เวลา 20:52<br>
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


## Project/api

`connected.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```php
<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "com_2305-project";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

```


## Project/api/reservation

`delete.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 14:47<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");
include("../../function/page.php");

try {
   $reservation_date = $_POST['reservation_date'];
   $student_id = $_POST['student_id'];
   $day_of_week = $_POST['day_of_week'];
   $time_slot_1 = $_POST['time_slot_1'];
   $goto_slot_1 = $_POST['goto_slot_1'];
   $time_slot_2 =  $_POST['time_slot_2'] ?? null;
   $goto_slot_2 =  $_POST['goto_slot_2'] ?? null;

   if (!$reservation_date || !$student_id || !$day_of_week || !$time_slot_1 || !$goto_slot_1) {
      http_response_code(400);
      echo json_encode([
         'status_code' => http_response_code()
      ]);
      exit;
   }

   $query = "DELETE FROM reservations WHERE reservation_date = ? AND student_id = ? AND day_of_week = ? AND time_slot_1 = ? AND goto_slot_1 = ?";
   $params = array($reservation_date, $student_id, $day_of_week, $time_slot_1, $goto_slot_1);
   $types = "sssss";

   if ($time_slot_2 !== null) {
      $query .= " AND time_slot_2 = ?";
      $params[] = $time_slot_2;
      $types .= "s";
   }

   if ($goto_slot_2 !== null) {
      $query .= " AND goto_slot_2 = ?";
      $params[] = $goto_slot_2;
      $types .= "s";
   }

   $stmt = mysqli_prepare($db, $query);
   if ($stmt === false) {
      throw new Exception("Failed to prepare statement");
   }

   mysqli_stmt_bind_param($stmt, $types, ...$params);

   if (!mysqli_stmt_execute($stmt)) {
      throw new Exception("Failed to execute statement");
   }

   http_response_code(200);
   echo json_encode([
      'status_code' => http_response_code()
   ]);
} catch (Exception $e) {
   http_response_code(500);
   echo json_encode([
      'status_code' => http_response_code(),
      'error' => $e->getMessage()
   ]);
} finally {
   if (isset($stmt) && $stmt !== false) {
      mysqli_stmt_close($stmt);
   }
   mysqli_close($db);
   exit;
}

```

`enum.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 14:24<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");

$response = [];

try {
   $response = [
      'days_of_week' => get_enum_values($db, 'reservations', 'day_of_week'),
      'time_slots' => get_enum_values($db, 'reservations', 'time_slot_1'),
      'goto_slots' => get_enum_values($db, 'reservations', 'goto_slot_1')
   ];
   http_response_code(200);
} catch (Exception $e) {
   http_response_code(500);
} finally {
   mysqli_close($db);
   echo json_encode([
      'status_code' => http_response_code(),
      'data' => $response
   ]);
   exit;
}

```

`get.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

try {
   if (isset($_GET['student_id'])) {
      $student_id = intval($_GET['student_id']);
      $sql = "SELECT * FROM reservations WHERE student_id = ?";
      $stmt = mysqli_prepare($db, $sql);
      if (!$stmt) {
         throw new Exception("Failed to prepare statement: " . mysqli_error($db));
      }
      mysqli_stmt_bind_param($stmt, "i", $student_id);
   } else {
      $sql = "SELECT * FROM reservations";
      $stmt = mysqli_prepare($db, $sql);
      if (!$stmt) {
         throw new Exception("Failed to prepare statement: " . mysqli_error($db));
      }
   }

   mysqli_stmt_execute($stmt);

   $result = mysqli_stmt_get_result($stmt);
   $reservations = array();

   while ($row = mysqli_fetch_assoc($result)) {
      $reservations[] = $row;
   }

   echo json_encode($reservations);
} catch (Exception $e) {
   echo json_encode(array("error" => $e->getMessage()));
} finally {
   if (isset($stmt)) {
      mysqli_stmt_close($stmt);
   }
   mysqli_close($db);
   exit();
}

```

`post.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

$response = [];

try {
   if ($_SERVER["REQUEST_METHOD"] !== "POST") {
      http_response_code(405);
      echo json_encode(['status_code' => http_response_code(), "error" => "Invalid request method"]);
      exit;
   }

   include("../../function/reservation/valid-reservation.php");
   include("../../function/reservation/valid-student.php");

   $reservation_date = $_POST['reservation_date'];
   $student_id = $_POST['student_id'];
   $status = $_POST['status'];
   $day_of_week = $_POST['day_of_week'];
   $time_slot_1 = $_POST['time_slot_1'];
   $goto_slot_1 = $_POST['goto_slot_1'];
   $time_slot_2 = $_POST['time_slot_2'] ?? null;
   $goto_slot_2 = $_POST['goto_slot_2'] ?? null;

   $errors = [];

   foreach ($fields_to_validate as $field => $valid_values) {
      if (!in_array($$field, $valid_values)) {
         $errors[] = "Invalid $field value: {$$field}. Valid values are: " . implode(", ", $valid_values);
      }
   }

   if (!is_valid_student($db, $student_id)) {
      http_response_code(400);
      echo json_encode(['status_code' => http_response_code(), "error" => "Invalid student ID"]);
      exit;
   }

   if (!empty($errors)) {
      http_response_code(400);
      echo json_encode(['status_code' => http_response_code(), "errors" => $errors]);
      exit;
   }

   $query = "SELECT * FROM reservations WHERE student_id = ? AND reservation_date = ?";
   $stmt = mysqli_prepare($db, $query);
   mysqli_stmt_bind_param($stmt, "is", $student_id, $reservation_date);
   mysqli_stmt_execute($stmt);
   $result = mysqli_stmt_get_result($stmt);

   if (mysqli_num_rows($result) > 0) {
      $query = "UPDATE reservations SET status = ?, day_of_week = ?, time_slot_1 = ?, goto_slot_1 = ?, time_slot_2 = ?, goto_slot_2 = ? WHERE student_id = ? AND reservation_date = ?";
      $stmt = mysqli_prepare($db, $query);
      mysqli_stmt_bind_param($stmt, "ssssssis", $status, $day_of_week, $time_slot_1, $goto_slot_1, $time_slot_2, $goto_slot_2, $student_id, $reservation_date);
   } else {
      $query = "INSERT INTO reservations (student_id, reservation_date, status, day_of_week, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      $stmt = mysqli_prepare($db, $query);
      mysqli_stmt_bind_param($stmt, "isssssss", $student_id, $reservation_date, $status, $day_of_week, $time_slot_1, $goto_slot_1, $time_slot_2, $goto_slot_2);
   }

   if (mysqli_stmt_execute($stmt)) {
      http_response_code(200);
      $response = ["message" => "Reservation successfully saved"];
   } else {
      switch (mysqli_errno($db)) {
         case 1062:
            http_response_code(409);
            $response = ["error" => "Duplicate entry"];
            break;
         default:
            http_response_code(500);
            $response = ["error" => "Internal server error"];
            break;
      }
   }

   echo json_encode(['status_code' => http_response_code(), 'data' => $response]);
} catch (Exception $e) {
   http_response_code(500);
   echo json_encode(['status_code' => http_response_code(), 'error' => 'An unexpected error occurred', 'details' => $e->getMessage()]);
} finally {
   if (isset($stmt)) {
      mysqli_stmt_close($stmt);
   }
   if (isset($db)) {
      mysqli_close($db);
   }
}
exit;

```

`schema.sql`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```sql
CREATE TABLE `reservations` (
	`reservation_id` int(11) NOT NULL AUTO_INCREMENT,
	`reservation_date` date NOT NULL,
	`student_id` int(11) NOT NULL,
	`status` varchar(50) DEFAULT NULL,
	`day_of_week` ENUM ('วันจันทร์', 'วันอังคาร', 'วันพุธ', 'วันพฤหัสบดี', 'วันศุกร์', 'วันเสาร์', 'วันอาทิตย์') NOT NULL,
	`time_slot_1` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45') NOT NULL,
	`goto_slot_1` ENUM ('ไปแม่ริม', 'ไปเวียงบัว') NOT NULL,
	`time_slot_2` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45'),
	`goto_slot_2` ENUM ('ไปแม่ริม', 'ไปเวียงบัว'),
	PRIMARY KEY (`reservation_id`)
);

```


## Project/api/student

`get.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

$query = "SELECT * FROM `student`";
$students = array();

try {
   if ($stmt = mysqli_prepare($db, $query)) {
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);

      if (mysqli_num_rows($result) > 0) {
         while ($row = mysqli_fetch_assoc($result)) {
            $students[] = $row;
         }
         http_response_code(200);
         $response = [
            'status_code' => http_response_code(),
            'data' => $students
         ];
      } else {
         http_response_code(404);
         $response = [
            'status_code' => http_response_code(),
            'error' => 'No students found.'
         ];
      }
      mysqli_stmt_close($stmt);
   } else {
      throw new Exception('Failed to prepare the SQL statement.');
   }
} catch (Exception $e) {
   http_response_code(500);
   $response = [
      'status_code' => http_response_code(),
      'error' => 'Internal server error: ' . $e->getMessage()
   ];
} finally {
   mysqli_close($db);
   echo json_encode($response);
   exit();
}

```

`schema.sql`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
CREATE TABLE `student` (`id` int(11) PRIMARY KEY, `section` int(11) DEFAULT NULL, `name` varchar(255) DEFAULT NULL, `status` varchar(50) DEFAULT NULL)

```

`values.sql`<br>
สร้าง: 6 ต.ค. 2567 เวลา 02:16<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
INSERT INTO
	`student` (id, section, name)
SELECT
	66143000,
	0,
	'Test'
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			`student`
		WHERE
			id = 66143000
	);

```


## Project/api/user

`post.php`<br>
สร้าง: 8 ต.ค. 2567 เวลา 13:04<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);

try {
   $user = $_POST['user'] ?? $_POST['username'];
   $password = $_POST['password'];

   $query = "SELECT user.id, user.password, student.id AS student_id, student.section, student.name, student.status 
      FROM user 
      LEFT JOIN student ON user.student_id = student.id 
      WHERE user.username = ? OR student.id = ? LIMIT 1";

   $stmt = mysqli_prepare($db, $query);
   mysqli_stmt_bind_param($stmt, "ss", $user, $user);
   mysqli_stmt_execute($stmt);
   $result = mysqli_stmt_get_result($stmt);

   if (mysqli_num_rows($result) > 0) {
      $user = mysqli_fetch_assoc($result);
      if ($password === $user['password']) {
         http_response_code(200);
         echo json_encode([
            "status_code" => http_response_code(),
            "message" => "Login successful",
            "data" => [
               "user_id" => $user['id'],
               "student_id" => $user['student_id'],
               "section" => $user['section'],
               "name" => $user['name'],
               "status" => $user['status'],
            ],
         ]);
      } else {
         http_response_code(401);
         echo json_encode([
            "status_code" => http_response_code(),
            "message" => "Invalid password"
         ]);
      }
   } else {
      http_response_code(404);
      echo json_encode([
         "status_code" => http_response_code(),
         "message" => "User not found"
      ]);
   }

   mysqli_stmt_close($stmt);
   mysqli_close($db);
} catch (mysqli_sql_exception $e) {
   http_response_code(500);
   echo json_encode([
      "error" => $e->getMessage(),
      "status_code" => http_response_code()
   ]);
}

```

`schema.sql`<br>
สร้าง: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
CREATE TABLE `user` (
	`id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`student_id` int(11),
	`username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
	INDEX (`student_id`)
);

```

`values.sql`<br>
สร้าง: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
INSERT INTO
	`user` (`student_id`, `username`, `password`)
VALUES
	(66143000, 'test', '1234');

```


## Project/function

`page.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 14:47<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
class PageType {
   const JS = 'JS';
   const HTTP = 'HTTP';
}

function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

function reloadPage() {
   header("Location: " . $_SERVER['REQUEST_URI']);
   exit();
}

```


## Project/function/reservation

`get_enum_values.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```php
<?php
function get_enum_values($db, $table, $column) {
   $query = "SHOW COLUMNS FROM `$table` LIKE '$column'";
   $result = mysqli_query($db, $query);
   $row = mysqli_fetch_assoc($result);

   preg_match_all("/'([^']+)'/", $row['Type'], $matches);
   return $matches[1];
}

```

`valid-reservation.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
include("get_enum_values.php");

$valid_days_of_week = get_enum_values($db, 'reservations', 'day_of_week');
$valid_time_slots = get_enum_values($db, 'reservations', 'time_slot_1');
$valid_goto_slots = get_enum_values($db, 'reservations', 'goto_slot_1');
$fields_to_validate = [
   'day_of_week' => $valid_days_of_week,
   'time_slot_1' => $valid_time_slots,
   'goto_slot_1' => $valid_goto_slots,
];

```

`valid-student.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```php
<?php
function is_valid_student($db, $student_id) {
   $student_check_query = "SELECT id FROM `student` WHERE id = ?";
   $student_check_stmt = mysqli_prepare($db, $student_check_query);

   mysqli_stmt_bind_param($student_check_stmt, "i", $student_id);
   mysqli_stmt_execute($student_check_stmt);
   mysqli_stmt_store_result($student_check_stmt);

   if (mysqli_stmt_num_rows($student_check_stmt) == 0) {
      mysqli_stmt_close($student_check_stmt);
      return false;
   }

   mysqli_stmt_close($student_check_stmt);
   return true;
}

```


## Project/script

`alerts.js`<br>
สร้าง: 6 ต.ค. 2567 เวลา 20:52<br>
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
สร้าง: 6 ต.ค. 2567 เวลา 20:52<br>
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
สร้าง: 6 ต.ค. 2567 เวลา 20:52<br>
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
สร้าง: 6 ต.ค. 2567 เวลา 20:52<br>
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
สร้าง: 6 ต.ค. 2567 เวลา 20:52<br>
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


## sphp

`pre_load.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 20:11<br>
แก้ไขล่าสุด: เวลา 20:12<br>

```php
<?php
set_time_limit(0);

```
