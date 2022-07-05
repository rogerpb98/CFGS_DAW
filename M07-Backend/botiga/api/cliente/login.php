<?php
//curl -X POST -d '{"user": "antonia44", "pwd": "1234"}' localhost/M07/UF2/botiga/api/cliente/login.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    $pwd = $data["pwd"];
    
    $sql = $con->prepare("SELECT USER, PASSWORD FROM CLIENTE WHERE USER=? AND PASSWORD=?");
    $sql->bind_param("ss",$user,$pwd);
    $sql->execute();
    $sql->bind_result($userQ, $pwdQ);
    if ($sql->fetch()) {
        $response["message"] = "OK";
        $response["user"] = $userQ;

        session_start();
        $_SESSION["user"]=$userQ;
        echo $_SESSION["user"];
        //setcookie('user', $userQ, "", "/");
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>