<?php
setcookie("first_name", '', time() - 3600, "/");
setcookie("last_name", '', time() - 3600, "/");
header("Refresh:0; url=welcome.php");
