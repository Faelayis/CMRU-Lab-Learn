# OOP Database - Note Management System

ระบบจัดการบันทึกย่อ (Note Management System) ที่พัฒนาด้วย [Java Swing](<http://en.wikipedia.org/wiki/Swing_(Java)>) และรองรับการเชื่อมต่อฐานข้อมูลหลายรูปแบบ

## Development 🚀

- แนะนำ [VS Code](https://code.visualstudio.com) เพื่อพัฒนา<br>
  ต้องใช้ Java [adoptium](https://adoptium.net/temurin/releases?arch=x64) หริอ [oracle](https://www.oracle.com/asean/java/technologies/downloads/) เวอร์ชัน 20+ หรือ LTS
- แนะนำ MySQL Server หรือ [XAMPP](https://www.apachefriends.org/) สำหรับการใช้งานแบบออนไลน์

### VS Code Extensions 🧩

- แนะนำ [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java)
- แนะนำ [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug)

### Project Structure

```text
OOP_Database/
├── src/
│   ├── App.java
│   ├── GUI.java
│   ├── database/
│   │   ├── DatabaseConfig.java
│   │   ├── DatabaseInterface.java
│   │   ├── DatabaseManager.java
│   │   ├── OfflineDatabase.java
│   │   └── providers/
│   │       └── MySQL.java
│   ├── model/
│   │   ├── Note.java
│   │   ├── Category.java
│   │   └── NoteManager.java
│   └── gui/
│       └── SettingsGUI.java
├── lib/
│   └── mysql-connector-j-9.4.0.jar
├── database.properties
└── notes_data.txt
```

## Installation & Setup 🛠️

### 1. Clone หรือ Download โปรเจกต์

```bash
git clone https://github.com/Faelayis/CMRU-Lab-Learn.git
cd CMRU-Lab-Learn/COM-3302/Project/OOP_Database
```

**หรือ [DownGit](https://downgit.github.io/#/home?url=https://github.com/Faelayis/CMRU-Lab-Learn/tree/main/COM-3302/Project/OOP_Database) เฉพาะโฟลเดอร์นี้**

### 2. Setup Database (ทางเลือก)

#### MySQL Setup

```sql
CREATE DATABASE notedb;
CREATE USER 'noteuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON notedb.* TO 'noteuser'@'localhost';
FLUSH PRIVILEGES;
```

### 3. การตั้งค่าฐานข้อมูล

เปิดโปรแกรมแล้วไปที่ **Database > Database Settings** เพื่อตั้งค่า:

- **Offline Mode**: ใช้ไฟล์ `notes_data.txt` (ค่าเริ่มต้น)
- **MySQL**: กำหนด host, port, database, username, password

## การใช้งาน 📖

### การรัน Application

#### แบบ Command Line

```bash
javac -cp "lib/*:src" src/App.java
java -cp "lib/*:src" App
```

#### แบบ VS Code

1. เปิดไฟล์ `App.java`
2. กด **F5** หรือไปที่ **Run > Start Debugging**

### คุณสมบัติหลัก

1. **เพิ่มบันทึกใหม่**: กรอกข้อมูลในฟอร์มด้านขวาแล้วคลิก "Save"
2. **แก้ไขบันทึก**: เลือกบันทึกจากตาราง แก้ไขข้อมูล แล้วคลิก "Update"
3. **ลบบันทึก**: เลือกบันทึกแล้วคลิก "Delete"
4. **ค้นหา**: พิมพ์คำค้นหาในช่อง Search
5. **สถิติ**: ไปที่ **View > Statistics**

### Keyboard Shortcuts

- **Ctrl+N**: สร้างบันทึกใหม่ (Clear Form)
- **F5**: รีเฟรชข้อมูล
- **Enter**: ค้นหาข้อมูล (ในช่อง Search)

## Database Configuration 🗄️

### ไฟล์ `database.properties`

```properties
# Database Configuration
type=OFFLINE # OFFLINE, MYSQL, FIREBASE
autoConnect=true # เชื่อมต่ออัตโนมัติเมื่อเริ่มโปรแกรม

# MySQL Settings
host=localhost
port=3306
database=note
username=root
password=pass
```

## Architecture & Design Patterns

### Design Patterns ที่ใช้

- **MVC Pattern**: แบ่งแยก Model (Note, Category), View (GUI), Controller (NoteManager)
- **Strategy Pattern**: DatabaseInterface และ providers สำหรับฐานข้อมูลหลายรูปแบบ
- **Singleton Pattern**: DatabaseManager สำหรับจัดการการเชื่อมต่อฐานข้อมูล
- **Observer Pattern**: Event handling ใน GUI components

### Class Diagram

```text
                    ┌─────────────────┐
                    │       App       │ ◄─── Entry Point
                    │   + main()      │
                    └─────────────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │       GUI       │ ◄─── Main Interface
                    │  - noteManager  │
                    │  - noteTable    │
                    │  + GUI()        │
                    └─────────────────┘
                             │
                             ▼
┌─────────────────┐          │          ┌─────────────────┐
│   NoteManager   │◄─────────┼─────────►│      Note       │
│  - notes        │          │          │  - id           │
│  - categoryIdx  │          │          │  - title        │
│  - dbManager    │          │          │  - content      │
│  + addNote()    │          │          │  - priority     │
│  + updateNote() │          │          │  + Priority     │ ◄─── Enum
│  + deleteNote() │          │          │  (LOW/MED/HIGH) │
└─────────────────┘          │          └─────────────────┘
         │                   │                   │
         ▼                   │                   ▼
┌─────────────────┐          │          ┌─────────────────┐
│ DatabaseManager │          │          │    Category     │
│   - database    │          │          │  - name         │
│   - config      │          │          │  - description  │
│   + initDB()    │          │          └─────────────────┘
│   + syncData()  │          │
└─────────────────┘          │
         │                   │
         ▼                   ▼
┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
│DatabaseInterface│ │ DatabaseConfig  │ │  SettingsGUI    │
│   + connect()   │ │   - type        │ │  - configPanel  │
│   + save()      │ │   - host        │ │  + showDialog() │
│   + load()      │ │   - port        │ │  + updateDB()   │
└─────────────────┘ │   - username    │ └─────────────────┘
         ▲          │   - password    │          ▲
         │          └─────────────────┘          │
         │                   │                   │
    ┌────┴────┐              └───────────────────┘
    ▼         ▼
┌─────────────────┐ ┌─────────────────┐
│ OfflineDatabase │ │  MySQLProvider  │ ◄─── Strategy Pattern
│  + loadNotes()  │ │  + connect()    │
│  + saveNotes()  │ │  + execute()    │
│  + isConnected  │ │  + disconnect() │
└─────────────────┘ └─────────────────┘
```
