<?php
//curl -X DELETE -d '{"user":"antonia44"}' localhost/M07/UF2/botigaPDO/api/cliente/delete-user.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "DELETE") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];
    //deletes dependancies
    $sql = "DELETE FROM PRODUCTO WHERE CLIENTE_USER=?";
    $statement = $con->prepare($sql);
    $statement->execute(array($user));
    //deletes user
    $sql = "DELETE FROM CLIENTE WHERE USER=?";
    $statement = $con->prepare($sql);
    $statement->execute(array($user));
    if (!($statement->rowCount()===0)) {
        $response["message"] = "OK";
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>