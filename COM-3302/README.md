# COM 3302 การเขียนโปรแกรมเชิงวัตถุ

## การพัฒนา

แนะนำ [Windows Terminal](https://www.microsoft.com/store/productid/9N0DX20HK701?ocid=pdpshare) เพื่อการทดสอบ<br>
ต้องใช้ [VS Code](https://code.visualstudio.com) เพื่อพัฒนาหรือการสร้าง<br>
ต้องใช้ Java [adoptium](https://adoptium.net/temurin/releases?arch=x64) หริอ [oracle](https://www.oracle.com/asean/java/technologies/downloads/) เวอร์ชัน 21+ หรือ LTS

### ส่วนขยาย

- ต้องใช้ [Language Support for Java(TM) by Red Hat](ttps://marketplace.visualstudio.com/items?itemName=redhat.java)
- ต้องใช้ [Debugger for Java](hhttps://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug)

### Windows

```text
📂.vscode
├─📄launch.json
└─📄settings.json
```

`launch.json`

```json
{
	"configurations": [
		{
			"type": "java",
			"name": "Run Java Current File",
			"request": "launch",
			"mainClass": "${file}",
			"console": "externalTerminal"
		}
	],
	"version": "0.2.0"
}
```

`settings.json` (Formatter)

```json
{
	"[java]": {
		"editor.defaultFormatter": "redhat.java"
	},
	"editor.formatOnSave": true
}
```

### เสร็จสิ้น

กด F5 ในไฟล์ที่ต้องการเพื่อทดสอบ<br>
