<?php
    if (!(isset($_COOKIE['user']) && isset($_COOKIE['password']))) {
        header("Location: login.php"); 
        exit();
    }
    setcookie('articles', null, time()-(24*60*60));
    setcookie('prices', null, time()-(24*60*60));
    header("Location: tenda.php"); 
    exit();
?>
