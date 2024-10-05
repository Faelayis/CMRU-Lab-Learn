`page.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 14:47<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
class PageType {
   const JS = 'JS';
   const HTTP = 'HTTP';
}

function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

function reloadPage() {
   header("Location: " . $_SERVER['REQUEST_URI']);
   exit();
}

```
