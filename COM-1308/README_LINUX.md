## การกำหนดค่า (Linux)

<!-- prettier-ignore -->
> [!WARNING]
> ตั้งค่านี้ทดลองใช้ Fedora เท่านั้น<br>
> *อาจจะใช้ไม่ได้บน Linux distro ตัวอื่นๆ*

ต้องใช้ [GCC Compiler](https://gcc.gnu.org/install/)<br>

```text
📂.vscode
├─📄c_cpp_properties.json
└─📄tasks.json
```

`c_cpp_properties.json`

```json
{
	"configurations": [
		{
			"name": "linux-gcc-x64",
			"cStandard": "c99",
			"cppStandard": "gnu++11",
			"includePath": ["${default}"],
			"compilerPath": "/usr/bin/gcc",
			"compilerArgs": ["-std=c11", "-std=gun11"],
		}
	],
	"version": 4
}
```

`tasks.json`

```json
{
	"tasks": [
		{
			"command": "/usr/bin/gcc",
			"label": "C/C++: gcc build active file",
			"type": "shell",
			"args": ["-fdiagnostics-color=always", "-g", "${file}", "-o", "${fileDirname}\\${fileBasenameNoExtension}"],
			"group": {
				"kind": "build",
				"isDefault": true
			},
			"options": {
				"cwd": "${fileDirname}"
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
