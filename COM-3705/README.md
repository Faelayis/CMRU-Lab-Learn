# COM 3705 Internet of Things

## Development 🚀

ต้องใช้ [Arduino IDE](https://www.arduino.cc/en/software/) เพื่อพัฒนาหรือการสร้าง<br>

Additional Boards Manager URLs (ESP8266) <br>

```text
http://arduino.esp8266.com/stable/package_esp8266com_index.json
```

Board: NodeMCU 1.0 (ESP-12E Module)

## [Bun SQLite](https://bun.com/docs/api/sqlite) + [sqlite_web](https://github.com/coleifer/sqlite-web)

```
bun run start
```

### Linux

Fix Permission denied <br>

```
sudo chmod a+rw /dev/ttyUSB0
```

## phpMyAdmin

sudo dnf install mysql-server
sudo dnf install httpd php php-mysqlnd php-json php-mbstring php-zip php-gd php-intl

sudo systemctl start mysqld
sudo systemctl start httpd

```php
CREATE USER 'fae'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON*.\_ TO 'fae'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
