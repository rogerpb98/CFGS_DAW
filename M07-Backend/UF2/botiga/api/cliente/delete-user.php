<?php
//curl -X DELETE -d '{"user":"juancho"}' localhost/M07/UF2/botiga/api/cliente/delete-user.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "DELETE") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    //deletes dependancies
    $sql = $con->prepare("DELETE FROM PRODUCTO WHERE CLIENTE_USER=?");
    $sql->bind_param("s",$user);
    $sql->execute();
    //deletes user
    $sql = $con->prepare("DELETE FROM CLIENTE WHERE USER=?");
    $sql->bind_param("s",$user);
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