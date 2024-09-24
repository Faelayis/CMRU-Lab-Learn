`previous_page.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 16:53<br>
```php
<?php
function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

```
