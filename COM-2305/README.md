# COM 2305 การเขียนโปรแกรมเว็บ

## การพัฒนา

แนะนำ [VS Code](https://code.visualstudio.com) เพื่อพัฒนา<br>
ต้องใช้ [XAMPP](#xampp) หรือ [NodeJS](#nodejs-expressjs) (ทางเลือก)

### ส่วนขยาย

-   แนะนำ [Auto Rename Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-rename-tag)
-   แนะนำ [Auto Close Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-close-tag)
-   แนะนำ [IntelliSense for CSS class names in HTML](https://marketplace.visualstudio.com/items?itemName=Zignd.html-css-class-completion)
-   แนะนำ [HTML CSS Support](https://marketplace.visualstudio.com/items?itemName=ecmel.vscode-html-css)
-   แนะนำ [HTML Preview](https://marketplace.visualstudio.com/items?itemName=george-alisson.html-preview-vscode)

### การกำหนดค่า

### XAMPP

-   ต้องใช้ [XAMPP](https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/8.2.12/xampp-windows-x64-8.2.12-0-VS16-installer.exe/download) เวอร์ชัน 8.2.X หรือมากกว่า

`xampp\apache\conf\httpd.conf`

```
Listen 3000
DocumentRoot "COM-2305"
```

### NodeJS (Express.js)

-   ต้องใช้ [NodeJS](https://nodejs.org/en) เวอร์ชัน 18 หรือมากกว่า
-   ต้องใช้ [Express](https://nodejs.org/en) เวอร์ชัน 5.X หรือมากกว่า
-   ต้องใช้ [serve-index](https://www.npmjs.com/package/serve-index) เวอร์ชัน 1.9.X หรือมากกว่า

<ol>
  <li>ติดตั้ง Node.js และ npm แล้วตรวจสอบว่า Node.js และ npm ติดตั้งแล้วโดยใช้คำสั่ง <code>node -v && npm -v</code>
  </li>
  <li>สร้างโปรเจกต์ใหม่ เปิดเทอร์มินัลหรือ Command Prompt แล้วสร้างโฟลเดอร์ใหม่สำหรับโปรเจกต์แล้วใช้คำสั้ง <code>npm init -y</code></li>
  <li>ติดตั้ง dependencies ติดตั้ง Express และ serve-index ด้วย npm <code>npm install express serve-index</code></li>
  <li>สร้างไฟล์ <a href="#appjs">app.js</a></li>
  <li>เริ่มเซิร์ฟเวอร์ด้วยคำสั่ง <code>node app.js</code></li>
</ol>

#### `app.js` <br>

ESM

```js
import express from "express"; // นำเข้าโมดูล express, path, serve-index
import path from "path";
import serveIndex from "serve-index";

const app = express();

// กำหนดให้ express ใช้ static files จากโฟลเดอร์ปัจจุบัน
app.use(express.static(path.resolve(__dirname, ".")));

// กำหนดเส้นทางหลักให้ใช้ serveIndex แสดงรายการไฟล์ในโฟลเดอร์ปัจจุบัน
app.use("/", serveIndex(path.resolve(__dirname, "."), { icons: true }));

// เริ่มต้นเซิร์ฟเวอร์ให้ฟังที่พอร์ต 3000
app.listen(3000, () => {
	console.log("Server is running on http://localhost:3000");
});
```

<details>
<summary>ES6</summary>

```js
const express = require("express");
const path = require("path");
const serveIndex = require("serve-index");

const app = express();

app.use(express.static(path.join(__dirname, ".")));
app.use("/", serveIndex(path.join(__dirname, "."), { icons: true }));
app.listen(3000, function () {
	console.log("Server is running on http://localhost:3000");
});
```

</details>
