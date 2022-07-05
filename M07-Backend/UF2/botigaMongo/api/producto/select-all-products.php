<?php
//curl -X GET localhost/M07/UF2/botigaPDO/api/producto/select-all-products.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $response = array();

    $sql = "SELECT * FROM PRODUCTO";
    $statement = $con->prepare($sql);
    $statement->execute();
    
    $producto=0;
    while ($fila=$statement->fetch(PDO::FETCH_ASSOC)) {
        $response[$producto]["id"] = $fila["ID"];
        $response[$producto]["nombre"] = $fila["NOMBRE"];
        $response[$producto]["categoria"] = $fila["CATEGORIA"];
        $response[$producto]["descripcion"] = $fila["DESCRIPCION"];
        $response[$producto]["precio"] = $fila["PRECIO"];
        $response[$producto]["foto1"] = $fila["FOTO1"];
        $response[$producto]["foto2"] = $fila["FOTO2"];
        $response[$producto]["foto3"] = $fila["FOTO3"];
        $response[$producto]["pdate"] = $fila["PUBLICATION_DATE"];
        $response[$producto]["visited"] = $fila["VISITED"];
        $response[$producto]["client"] = $fila["CLIENT_USER"];
        $producto++;
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>