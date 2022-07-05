<?php
//curl -X GET localhost/M07/UF2/botigaPDO/api/producto/select-by-id.php?id=1
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $id = $_GET["id"];
    $response = array();

    $sql = "SELECT * FROM PRODUCTO WHERE ID = ?";
    $statement = $con->prepare($sql);
    $statement->execute(array($id));
    
    while ($fila=$statement->fetch(PDO::FETCH_ASSOC)) {
        $response["id"] = $fila["ID"];
        $response["nombre"] = $fila["NOMBRE"];
        $response["categoria"] = $fila["CATEGORIA"];
        $response["descripcion"] = $fila["DESCRIPCION"];
        $response["precio"] = $fila["PRECIO"];
        $response["foto1"] = $fila["FOTO1"];
        $response["foto2"] = $fila["FOTO2"];
        $response["foto3"] = $fila["FOTO3"];
        $response["pdate"] = $fila["PUBLICATION_DATE"];
        $response["visited"] = $fila["VISITED"];
        $response["client"] = $fila["CLIENTE_USER"];
        $producto++;
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>