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
