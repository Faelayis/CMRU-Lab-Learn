# COM 2305 การเขียนโปรแกรมเว็บ

## การพัฒนา

แนะนำ [VS Code](https://code.visualstudio.com) เพื่อพัฒนา<br>
ต้องใช้ [XAMPP](#xampp) หรือ [PHP Desktop](https://github.com/cztomczak/phpdesktop) และ [NodeJS](#nodejs-expressjs) (ทางเลือก)

<!-- prettier-ignore -->
> [!TIP]
> **แนะนำ**
> PHP Desktop ง่ายต่อการพัฒนาอย่างมาก

### ส่วนขยาย

- แนะนำ [IntelliSense for CSS class names in HTML](https://marketplace.visualstudio.com/items?itemName=Zignd.html-css-class-completion)
- แนะนำ [Auto Rename Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-rename-tag)
- แนะนำ [Auto Close Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-close-tag)
- แนะนำ [HTML CSS Support](https://marketplace.visualstudio.com/items?itemName=ecmel.vscode-html-css)
- แนะนำ [HTML Preview](https://marketplace.visualstudio.com/items?itemName=george-alisson.html-preview-vscode)
- แนะนำ [PHP Intelephense](https://marketplace.visualstudio.com/items?itemName=bmewburn.vscode-intelephense-client)

### การกำหนดค่า

### XAMPP

<!-- prettier-ignore -->
> [!CAUTION]
> **เลิกใช้**
> ไม่แนะนำเนื่องจากการตั้งค่าที่เสียเวลา

<!-- <details>
<summary>รายละเอียด</summary>

-   ต้องใช้ [XAMPP](https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/8.2.12/xampp-windows-x64-8.2.12-0-VS16-installer.exe/download) เวอร์ชัน 8.2.X หรือมากกว่า

`xampp\apache\conf\httpd.conf`

```
Listen 3000
DocumentRoot "COM-2305"
```

</details> -->

### NodeJS (Express.js)

<!-- prettier-ignore -->
> [!WARNING]
> **พบปัญหา**
> เมื่อคุณใช้ฟังก์ชัน `setcookie()` หรือ `$_SESSION` หลายครั้งภายในสคริปต์เดียวกัน <br>
> *PHP* จะส่งเฉพาะที่กำหนดในบรรทัดสุดท้ายไปยังเบราว์เซอร์เท่านั้น <br>
> ต้องใช้ PHP Engine ของ XAMPP `C:\xampp\php` เพื่อแก้ไขปัญหา

- ต้องใช้ [NodeJS](https://nodejs.org/en) เวอร์ชัน 18 หรือมากกว่า
- ต้องใช้ [Express](https://nodejs.org/en) เวอร์ชัน 5.X หรือมากกว่า
- ต้องใช้ [serve-index](https://www.npmjs.com/package/serve-index) เวอร์ชัน 1.9.X หรือมากกว่า
- ต้องใช้ [sphp](https://www.npmjs.com/package/sphp) เวอร์ชัน 0.6.3 หรือมากกว่า

<ol>
  <li>ติดตั้ง Node.js และ npm แล้วตรวจสอบว่า Node.js และ npm ติดตั้งแล้วโดยใช้คำสั่ง <code>node -v && npm -v</code>
  </li>
  <li>สร้างโปรเจกต์ใหม่ เปิดเทอร์มินัลหรือ Command Prompt แล้วสร้างโฟลเดอร์ใหม่สำหรับโปรเจกต์แล้วใช้คำสั้ง <code>npm init -y</code></li>
  <li>ติดตั้ง dependencies ติดตั้ง Express และ serve-index ด้วย npm <code>npm install express serve-index sphp</code></li>
  <li>สร้างไฟล์ <a href="#appjs-">app.js</a></li>
  <li>เริ่มเซิร์ฟเวอร์ด้วยคำสั่ง <code>node app.js</code></li>
</ol>

#### `app.js` <br>

```js
const express = require("express"); // นำเข้าโมดูล express, path, serve-index, sphp
const path = require("path");
const serveIndex = require("serve-index");
const sphp = require("sphp");

const app = express();
const path_resolve = path.join(__dirname, ".");

// กำหนดให้ แปลงข้อมูล JSON ที่ส่งมากับ request และ แปลงข้อมูลที่ส่งมากับ request ในรูปแบบ URL-encoded
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
// กำหนดให้ express และ sphp ใช้ static files จากโฟลเดอร์ปัจจุบัน
app.use(sphp.express(path_resolve));
// และกำหนด PHP server เพื่อให้มีจำนวน การทำงาน ขั้นต่ำที่ 10 และสูงสุดที่ 20 ในการจัดการการทำงานของเว็บแอปพลิเคชัน PHP ที่มีการใช้งานหนักหรือมีการเข้าถึงพร้อมกันมากๆ
sphp.setOptions({ minSpareWorkers: 10, maxWorkers: 20 });
app.use(express.static(path_resolve));

// กำหนดเส้นทางหลักให้ใช้ serveIndex แสดงรายการไฟล์ในโฟลเดอร์ปัจจุบัน
app.use("/", serveIndex(path_resolve, { icons: true }));

// เริ่มต้นเซิร์ฟเวอร์ให้ฟังที่พอร์ต 3000
app.listen(3000, function () {
	console.log("Server is running on http://localhost:3000");
});
```

<details>
<summary>ESM</summary>

```js
import express from "express";
import path from "path";
import serveIndex from "serve-index";
import sphp from "sphp";

const app = express();
const path_resolve = path.resolve(__dirname, ".");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(sphp.express(path_resolve));
sphp.setOptions({ minSpareWorkers: 10, maxWorkers: 20 });
app.use(express.static(path_resolve));
app.use("/", serveIndex(path_resolve), { icons: true });
app.listen(3000, () => {
	console.log("Server is running on http://localhost:3000");
});
```

</details>
