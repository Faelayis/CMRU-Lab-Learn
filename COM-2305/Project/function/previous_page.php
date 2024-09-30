<?php
function previousPage() {
   header("Location: " . $_SERVER['HTTP_REFERER']);
   exit();
}
