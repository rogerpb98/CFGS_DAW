<?php
//curl -X POST -d '{"user": "antonia44", "pwd": "ruchi100", "nombre": "Roger", "apellido": "Perez"}' localhost/M07/UF2/botiga/api/cliente/update-user.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    $pwd = $data["pwd"];
    $nombre = $data["nombre"];
    $apellido = $data["apellido"];

    $sql = $con->prepare("UPDATE CLIENTE SET PASSWORD = ?, NOMBRE = ?, APELLIDO = ? WHERE USER = ?");
    $sql->bind_param("ssss",$pwd,$nombre,$apellido,$user);
    //$sql = "UPDATE CLIENTE SET PASSWORD = '".$pwd."', NOMBRE = '".$nombre."', APELLIDO = '".$apellido."' WHERE USER = '".$user."'";
    $sql->execute();
    if (!($sql->affected_rows===0)) {
        $response["message"] = "OK";
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>