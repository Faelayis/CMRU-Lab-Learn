# COM 1305 การเขียนโปรแกรมภาษาคอมพิวเตอร์

## การพัฒนา

แนะนำ [Windows Terminal](https://www.microsoft.com/store/productid/9N0DX20HK701?ocid=pdpshare) เพื่อการทดสอบ<br>
ต้องใช้ [VS Code](https://code.visualstudio.com) เพื่อพัฒนาหรือการสร้าง<br>
ต้องใช้ [Python](https://www.python.org/downloads) เวอร์ชัน 3.12.X หรือมากกว่า

### ส่วนขยาย

-   ต้องใช้ [Python](https://marketplace.visualstudio.com/items?itemName=ms-python.python)
-   ต้องใช้ [Pylance](https://marketplace.visualstudio.com/items?itemName=ms-python.vscode-pylance)
<!-- -   แนะนำ [Black formatter](https://marketplace.visualstudio.com/items?itemName=ms-python.black-formatter) -->
-   แนะนำ [Ruff](https://marketplace.visualstudio.com/items?itemName=charliermarsh.ruff)
-   แนะนำ [isort](https://marketplace.visualstudio.com/items?itemName=ms-python.isort)
-   แนะนำ [Flake8](https://marketplace.visualstudio.com/items?itemName=ms-python.flake8)

### Windows

สำหลับติดตั้ง Python 3.12 แบบด่วน<br>

[![](https://img.shields.io/badge/Microsoft%20Store-005FB8?logo=microsoftstore&logoColor=white)](https://www.microsoft.com/store/productId/9NCVDN91XZQP)
[![](https://img.shields.io/badge/PowerShell-5391FE?logo=PowerShell&logoColor=white)](https://aka.ms/powershell-release?tag=stable)

```ps1
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex "&{$((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/Faelayis/CMRU-Lab-Learn/main/setup/install_python.ps1'))}"
```

<!-- prettier-ignore -->
> [!WARNING]
> อาจจะต้องสร้าง [Python Environment](https://code.visualstudio.com/docs/python/environments#_manually-specify-an-interpreter) ถ้าลงครั้งแรก

```text
📂.vscode
└─📄launch.json
```

`launch.json`

```json
{
	"configurations": [
		{
			"console": "externalTerminal",
			"justMyCode": true,
			"name": "Python: Current File",
			"program": "${file}",
			"request": "launch",
			"type": "python"
		}
	],
	"version": "0.2.0"
}
```

`settings.json`

```json
{
	"[python]": {
		"editor.codeActionsOnSave": {
			"source.organizeImports": true
		},
		"editor.defaultFormatter": "ms-python.black-formatter",
		"editor.formatOnSave": true
	},
	"isort.args": ["--profile", "black"],
	"python.analysis.autoFormatStrings": true,
	"python.analysis.autoImportCompletions": true,
	"python.analysis.typeCheckingMode": "basic",
	"python.createEnvironment.contentButton": "show",
	"python.testing.autoTestDiscoverOnSaveEnabled": true
}
```

### เสร็จสิ้น

กด F5 ในไฟล์ที่ต้องการเพื่อทดสอบ<br>

<!-- prettier-ignore -->
> [!NOTE]
> [ทางลัดอื่นๆ](https://code.visualstudio.com/docs/editor/debugging#_debug-actions)
