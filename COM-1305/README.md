# COM 1305 การเขียนโปรแกรมภาษาคอมพิวเตอร์

## การพัฒนา

แนะนำ [Windows Terminal](https://www.microsoft.com/store/productid/9N0DX20HK701?ocid=pdpshare) เพื่อการทดสอบ<br>
ต้องใช้ [VS Code](https://code.visualstudio.com) เพื่อพัฒนาหรือการสร้าง<br>
ต้องใช้ [Python](https://www.python.org/downloads) เวอร์ชัน 3.12.X หรือมากกว่า

คำสั่งสำหลับติดตั้ง Python 3.12.0 แบบด่วน<br>

[![](https://img.shields.io/badge/PowerShell-5391FE?logo=PowerShell&logoColor=white)](https://aka.ms/powershell-release?tag=stable)

```ps1
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex "&{$((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/Faelayis/CMRU-Lab-Learn/main/setup/install_python.ps1'))}"
```
[Source](.././setup/install_python.ps1)

### ส่วนขยาย

-   ต้องใช้ [Python](https://marketplace.visualstudio.com/items?itemName=ms-python.python)
-   แนะนำ [autopep8](https://marketplace.visualstudio.com/items?itemName=ms-python.autopep8)
-   แนะนำ [isort](https://marketplace.visualstudio.com/items?itemName=ms-python.isort)

### Windows

<!-- prettier-ignore -->
> [!WARNING]
> อาจจะต้องสร้าง [Python Environment](https://code.visualstudio.com/docs/python/environments#_manually-specify-an-interpreter) ก่อน

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

### เสร็จสิ้น

กด F5 ในไฟล์ที่ต้องการเพื่อทดสอบ<br>

<!-- prettier-ignore -->
> [!NOTE]
> [ทางลัดอื่นๆ](https://code.visualstudio.com/docs/editor/debugging#_debug-actions)
