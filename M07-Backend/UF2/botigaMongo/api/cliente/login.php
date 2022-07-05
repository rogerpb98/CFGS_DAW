<?php
//curl -X POST -d '{"user": "meloguiso", "pwd": "1234"}' localhost/M07/UF2/botigaMongo/api/cliente/login.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    $pwd = $data["pwd"];
    //mongo
    $cliente = $con->botiga->client;
    $query = $cliente->findOne(['user' => $user, 'password' => $pwd]);
    
    $response['query']=$query;
    if ($query) {
        $response['message'] = "OK";
        session_start();
        $_SESSION["user"]=$user;
    } else {
        $response['message'] = "KO";
    }

    echo json_encode($response);
}
$con->close();
?>