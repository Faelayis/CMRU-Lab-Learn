# COM 2305 การเขียนโปรแกรมเว็บ

## การพัฒนา

แนะนำ [VS Code](https://code.visualstudio.com) เพื่อพัฒนา<br>
ต้องใช้ [XAMPP](./README.md#xampp) หรือ [NodeJS](./README.md#nodejs-expressjs)

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
Listen 1111
DocumentRoot "COM-2305"
```

### NodeJS (Express.js)

-   ต้องใช้ [NodeJS](https://nodejs.org/en) เวอร์ชัน 18 หรือมากกว่า
-   ต้องใช้ [Express](https://nodejs.org/en) เวอร์ชัน 5.X หรือมากกว่า
-   ต้องใช้ [serve-index](https://www.npmjs.com/package/serve-index) เวอร์ชัน 1.9.X หรือมากกว่า

`app.js`

```js
import express from "express";
import path from "path";
import serveIndex from "serve-index";

const app = express();

app.use(express.static(path.resolve(__dirname, ".")));
app.use("/", serveIndex(path.resolve(__dirname, "."), { icons: true }));

app.listen(3000, () => {
	console.log("Server is running on http://localhost:3000");
});
```
