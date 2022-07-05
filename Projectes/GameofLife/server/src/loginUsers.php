<?php //Script to connect to BBDD

    error_reporting(E_ALL);
    error_reporting(-1);
    ini_set('error_reporting', E_ALL);

    //Get values user and password from index.html form

    $user = $_POST['user'];
    $password = $_POST['password'];
    $host = "localhost";
    $dataBase = "BBDD";

    //$passwordEncrypt = password_hash('"'.$password.'"', PASSWORD_BCRYPT);

    //$passwordEncrypt = $password;   

    $server = mysqli_connect($host, "conway" , "1234", $dataBase);
    // Check connection
    if (!$server) {
        die("Connection failed: " . mysqli_connect_error());
    }

    //hacemos un select y lo guardamos en una query
    $userInfo = "SELECT usuario , password FROM logins where usuario = '".$user."' and password = '". $password ."';";

    echo $userInfo;


    $res = mysqli_query($server, $userInfo);

    //si no hay coincidencia devolvemos un mensaje que el usuario o la contraseña son incorrectos
    if( mysqli_num_rows($res)==0) {
        echo("no entrado");
        header("Location: http://localhost/GameofLife/client/login.php");
        die;
    }
    else {
        echo("entrado");
        setcookie('user', $user, time()+(24*60*60));
        header("Location: http://localhost/GameofLife/client/index.php");
    }

?>