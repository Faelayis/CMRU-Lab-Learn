`page.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 14:47<br>
```php
<?php
class PageType {
   const JS = 'JS';
   const HTTP = 'HTTP';
}

function previousPage(PageType $type): void {
   switch ($type) {
      case PageType::JS:
         echo "<script>window.history.back();</script>";
         break;
      case PageType::HTTP:
         header("Location: " . $_SERVER['HTTP_REFERER']);
         break;
      default:
         throw new InvalidArgumentException("Invalid page type");
   }
   exit();
}

function reloadPage() {
   header("Location: " . $_SERVER['REQUEST_URI']);
   exit();
}

```
