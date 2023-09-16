# COM 1308 หลักการออกแบบและการเขียนโปรแกรม

## การพัฒนา

แนะนำ [Windows Terminal](https://www.microsoft.com/store/productid/9N0DX20HK701?ocid=pdpshare) เพื่อการทดสอบ<br>
ต้องใช้ [VS Code](https://code.visualstudio.com) เพื่อพัฒนาหรือการสร้าง<br>
ต้องใช้ [Dev-C++ 5.11 TDM-GCC](https://sourceforge.net/projects/orwelldevcpp/files/latest/download) หรือ เวอร์ชันล่าสุด (คอมมหาลัย น่าจะมีอยู่แล้ว)

<!-- prettier-ignore -->
> [!WARNING]
> ต้องติดตั้งใน Path: `C:\Program Files (x86)\Dev-Cpp` เท่านั้น

### ส่วนขยาย

-   ต้องใช้ [C/C++](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools)
-   ต้องใช้ [C/C++ Extension Pack](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools-extension-pack)
<!-- -   แนะนำ [.NET Runtime Install Tool](https://marketplace.visualstudio.com/items?itemName=ms-dotnettools.vscode-dotnet-runtime) -->

### การกำหนดค่า 
-  [Linux](./README_LINUX.md)

### Windows

```text
📂.vscode
├─📄c_cpp_properties.json
├─📄launch.json
└─📄tasks.json
```

`c_cpp_properties.json`

```json
{
	"configurations": [
		{
			"name": "windows-gcc-x64",
			"includePath": ["${default}", "C:/Program Files (x86)/Dev-Cpp/MinGW64/**"],
			"compilerPath": "C:/Program Files (x86)/Dev-Cpp/MinGW64/bin/gcc.exe"
		}
	],
	"version": 4
}
```

`launch.json`

```json
{
	"configurations": [
		{
			"name": "Debug C/C++ Executable",
			"type": "cppvsdbg",
			"request": "launch",
			"program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
			"preLaunchTask": "C/C++: gcc.exe build active file",
			"console": "externalTerminal",
			"stopAtEntry": false,
			"suppressMultipleSessionWarning": true,
			"cwd": "${fileDirname}"
		}
	],
	"version": "0.2.0"
}
```

`tasks.json`

```json
{
	"tasks": [
		{
			"command": "C:/Program Files (x86)/Dev-Cpp/MinGW64/bin/gcc.exe",
			"label": "C/C++: gcc.exe build active file",
			"type": "cppbuild",
			"args": ["-fdiagnostics-color=always", "-g", "${file}", "-o", "${fileDirname}\\${fileBasenameNoExtension}.exe"],
			"group": {
				"kind": "build",
				"isDefault": true
			},
			"options": {
				"cwd": "C:/Program Files (x86)/Dev-Cpp/MinGW64/bin"
			},
			"presentation": {
				"clear": true,
				"echo": false,
				"focus": false,
				"panel": "shared",
				"reveal": "silent",
				"showReuseMessage": false
			},
			"problemMatcher": ["$gcc"]
		}
	],
	"version": "2.0.0"
}
```

### เสร็จสิ้น

กด F5 ในไฟล์ที่ต้องการเพื่อทดสอบ<br>
กด Shift + F5 เพื่อยกเลิก

<!-- prettier-ignore -->
> [!NOTE]
> [ทางลัดอื่นๆ](https://code.visualstudio.com/docs/editor/debugging#_debug-actions)
