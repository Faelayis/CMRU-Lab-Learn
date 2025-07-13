`editFaculty.js`<br>
Create: 24 ก.ย. 2567 time 17:27<br>
```js
window.editFaculty = function (id, name) {
	document.getElementById("fac_id").value = id;
	document.getElementById("id").value = id;
	document.getElementById("name").value = name;
};

```
`previous_page.php`<br>
Create: 17 ก.ย. 2567 time 01:33<br>
Update: 24 ก.ย. 2567 time 16:53<br>
```php
<?php
function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}

```
