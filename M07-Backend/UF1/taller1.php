<?php
    $user=$_GET['user'];
    $passwd=$_GET['passwd'];
    login($user,$passwd);
    function login($user,$passwd){
        checkUser($user);
        checkPasswd($passwd);
        echo("<br>".$user.$passwd);
    }
    function checkUser($user){
        if (strlen($user)<=3 || strlen($user)>16) {
            echo("User name has to be between 4 and 16 characters<br>");
        }
    }
    function checkPasswd($passwd){
        if (strlen($passwd)<8 || strlen($passwd)>16) {
            echo("Password has to be between 8 and 16 characters<br>");
        }
    }
?>