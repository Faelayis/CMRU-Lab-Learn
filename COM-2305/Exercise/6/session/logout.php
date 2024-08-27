<?php
session_start();
session_destroy();
// or
// unset($_SESSION["name"]);
// unset($_SESSION["username"]);
// unset($_SESSION["password"]);
header("Refresh:0; url=welcome.php");
