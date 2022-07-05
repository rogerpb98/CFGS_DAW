<?php
//curl -X POST -d '{"user": "meloguiso", "pwd": "1234"}' localhost/M07/UF2/botigaPDO/api/cliente/login.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    $pwd = $data["pwd"];
    
    $sql = "SELECT USER, PASSWORD FROM CLIENTE WHERE USER=? AND PASSWORD=?";
    $statement = $con->prepare($sql);
    $statement->execute(array($user,$pwd));


    //$sql->bind_result($userQ, $pwdQ);
    if ($fila=$statement->fetch(PDO::FETCH_ASSOC)) {
        $response["message"] = "OK";

        session_start();
        $_SESSION["user"]=$user;
        //setcookie('user', $userQ, "", "/");
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>