`previous_page.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 1 ต.ค. 2567 เวลา 03:36<br>
```php
<?php
function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

```
