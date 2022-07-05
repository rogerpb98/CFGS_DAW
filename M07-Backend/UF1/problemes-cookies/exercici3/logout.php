<?php
    if (!(isset($_COOKIE['user']) && isset($_COOKIE['password']))) {
        header("Location: login.php"); 
        exit();
    }
    setcookie('user', $user, time()-(24*60*60));
    setcookie('password', $pwd, time()-(24*60*60));
    header("Location: tenda.php"); 
    exit();
?>
