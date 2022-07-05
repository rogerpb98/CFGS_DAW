
<?php

    error_reporting(E_ALL);
    error_reporting(-1);
    ini_set('error_reporting', E_ALL);

    //Get values user and password from index.html form

    $user = $_POST['user'];
    $password = $_POST['password'];
    $host = "localhost";
    $dataBase = "BBDD";

    //$passwordEncrypt = password_hash('"'.$password.'"', PASSWORD_BCRYPT);
    
    $server = mysqli_connect($host, "conway" , "1234", $dataBase);
    // Check connection
    if (!$server) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $userInfo = "SELECT usuario FROM logins where usuario = '".$user."';";

    $resSelect = mysqli_query($server, $userInfo);
    
    //si no hay coincidencia devolvemos el error de la query
    $consulta =  mysqli_num_rows($resSelect);
    if( $consulta ==1) {
        header("Location: http://localhost/GameofLife/client/register.php");
        die;
    }
    else {
        $len_user = strlen($user);
        $len_password = strlen($password);
        if(($len_user> 0) && ($len_password > 0)) {
            //hacemos un insert y lo guardamos en una query
            $userInsert = "INSERT INTO logins (usuario, password) VALUES ('".$user."','". $password ."')";
            $insertQuery = mysqli_query($server, $userInsert);
        
            $resInsert = mysqli_query($server, $userInfo);
            
            if( mysqli_num_rows($resInsert)==1) {
                header("Location: http://localhost/GameofLife/client/login.php");

                die;
            }
            //header("Location: http://localhost/GameofLife/client/index.php");
        }
        else {
            header("Location: http://localhost/GameofLife/client/register.php");
            die;
        }
    }

?>

