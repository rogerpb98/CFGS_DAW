<?php
//curl -X POST -d '{"id":"1", "nombre": "asd", "desc": "cosa"}' localhost/M07/UF2/botigaPDO/api/producto/update-product.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    $nombre = $data["nombre"];
    $categoria = $data["categoria"];
    $desc = $data["desc"];
    $precio = $data["precio"];
    $fotos = $data["fotos"];

    $sql="";
    switch (count($fotos)) {
        //si no hay fotos
        case 0:
            $sql = "UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ? WHERE ID = ?";
            $statement = $con->prepare($sql);
            $statement->execute(array($nombre,$categoria,$desc,$precio,$id));
            
            break;
        //si hay fotos
        case 1:
            $sql = "UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ? WHERE ID = ?";
            $statement = $con->prepare($sql);
            $statement->execute(array($nombre,$categoria,$desc,$precio,$fotos[0],$id));

            break;
        case 2:
            $sql = "UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ?, FOTO2 = ? WHERE ID = ?";
            $statement = $con->prepare($sql);
            $statement->execute(array($nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1],$id));

            break;
        case 3:
            $sql = "UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ?, FOTO2 = ?, FOTO3 = ? WHERE ID = ?";
            $statement = $con->prepare($sql);
            $statement->execute(array($nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1],$fotos[2],$id));

            break;
    }
    
    if (!($statement->rowCount()===0)) {
        $response["message"] = "OK";
        $response["operation"] = $sql;
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>