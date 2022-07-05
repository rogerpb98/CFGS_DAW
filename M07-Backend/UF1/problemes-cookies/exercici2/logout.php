<?php
    setcookie('user', $user, time()-(24*60*60));
    setcookie('password', $pwd, time()-(24*60*60));
    header("Location: informacio1.php"); 
    exit();
?>
