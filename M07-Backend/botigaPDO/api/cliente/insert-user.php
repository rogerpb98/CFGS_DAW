<?php
//curl -X PUT -d '{"user":"ruchi99", "pwd": "ruchi100", "nombre": "Roger", "apellido": "Perez"}' localhost/M07/UF2/botigaPDO/api/cliente/insert-user.php
//curl -X PUT -d '{"user":"juancho", "pwd": "ruchi100", "nombre": "Rogelio"}' localhost/M07/UF2/botigaPDO/api/cliente/insert-user.php
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

            $sql = "INSERT INTO CLIENTE (USER, PASSWORD, NOMBRE) VALUES (?,?,?)";
            $statement = $con->prepare($sql);
            $statement->execute(array($user,$pwd,$nombre,$apellido));
            break;
        //si trae apellido hace un insert con apellido
        case 4:
            $user = $data["user"];
            $pwd = $data["pwd"];
            $nombre = $data["nombre"];
            $apellido = $data["apellido"];

            $sql = "INSERT INTO CLIENTE VALUES (?,?,?,?)";
            $statement = $con->prepare($sql);
            $statement->execute(array($user,$pwd,$nombre,$apellido));
            break;
    }
    //$statement->execute(array($user));
    if (!($statement->rowCount()===0)) {
        $response["message"] = "OK";
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>