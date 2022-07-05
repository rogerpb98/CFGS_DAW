<?php
//curl -X DELETE -d '{"id":1}' localhost/M07/UF2/botiga/api/producto/delete-product.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "DELETE") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    //deletes product
    $sql = $con->prepare("DELETE FROM PRODUCTO WHERE ID=?");
    $sql->bind_param("i",$id);
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