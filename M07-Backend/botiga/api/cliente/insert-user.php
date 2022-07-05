<?php
//curl -X PUT -d '{"user":"ruchi99", "pwd": "ruchi100", "nombre": "Roger", "apellido": "Perez"}' localhost/M07/UF2/botiga/api/cliente/insert-user.php
//curl -X PUT -d '{"user":"juancho", "pwd": "ruchi100", "nombre": "Rogelio"}' localhost/M07/UF2/botiga/api/cliente/insert-user.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "PUT") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $pwd = $nombre = $apellido = $sql;
    switch (count($data)) {
        //si no trae apellido hace un insert sin apellido
        case 3:
            $user = $data["user"];
            $pwd = $data["pwd"];
            $nombre = $data["nombre"];
            $sql = $con->prepare("INSERT INTO CLIENTE (USER, PASSWORD, NOMBRE) VALUES (?,?,?)");
            $sql->bind_param("sss",$user,$pwd,$nombre);
            break;
        //si trae apellido hace un insert con apellido
        case 4:
            $user = $data["user"];
            $pwd = $data["pwd"];
            $nombre = $data["nombre"];
            $apellido = $data["apellido"];

            $sql = $con->prepare("INSERT INTO CLIENTE VALUES (?,?,?,?)");
            $sql->bind_param("ssss",$user,$pwd,$nombre,$apellido);
            break;
    }
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