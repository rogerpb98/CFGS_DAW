<?php
//curl -X POST -d '{"user":"antonia44", "pwd": "ruchi100", "nombre": "Roger", "apellido": "Perez"}' localhost/M07/UF2/botiga/api/cliente/update-product.php
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

    $sql;
    switch (count($fotos)) {
        //si no hay fotos
        case 0:
            $sql = $con->prepare("UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ? WHERE ID = ?");
            $sql->bind_param("sssdi",$nombre,$categoria,$desc,$precio,$id);
            //$sql = "UPDATE PRODUCTO SET NOMBRE = '".$nombre."', CATEGORIA = '".$categoria."', DESCRIPCION = '".$desc."', PRECIO = '".$precio."' WHERE ID = '".$id."'";
            break;
        //si hay fotos
        case 1:
            $sql = $con->prepare("UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ? WHERE ID = ?");
            $sql->bind_param("sssdsi",$nombre,$categoria,$desc,$precio,$fotos[0],$id);
            //$sql = "UPDATE PRODUCTO SET NOMBRE = '".$nombre."', CATEGORIA = '".$categoria."', DESCRIPCION = '".$desc."', PRECIO = '".$precio."', FOTO1 = '".$fotos[0]."' WHERE ID = '".$id."'";
            break;
        case 2:
            $sql = $con->prepare("UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ?, FOTO2 = ? WHERE ID = ?");
            $sql->bind_param("sssdssi",$nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1],$id);
            //$sql = "UPDATE PRODUCTO SET NOMBRE = '".$nombre."', CATEGORIA = '".$categoria."', DESCRIPCION = '".$desc."', PRECIO = '".$precio."', FOTO1 = '".$fotos[0]."', FOTO2 = '".$fotos[1]."' WHERE ID = '".$id."'";
            break;
        case 3:
            $sql = $con->prepare("UPDATE PRODUCTO SET NOMBRE = ?, CATEGORIA = ?, DESCRIPCION = ?, PRECIO = ?, FOTO1 = ?, FOTO2 = ?, FOTO3 = ? WHERE ID = ?");
            $sql->bind_param("sssdsssi",$nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1],$fotos[2],$id);
            //$sql = "UPDATE PRODUCTO SET NOMBRE = '".$nombre."', CATEGORIA = '".$categoria."', DESCRIPCION = '".$desc."', PRECIO = '".$precio."', FOTO1 = '".$fotos[0]."', FOTO2 = '".$fotos[1]."', FOTO3 = '".$fotos[2]."' WHERE ID = '".$id."'";
            break;
    }
    $sql->execute();
    if (!($sql->affected_rows===0)) {
        $response["message"] = "OK";
        $response["operation"] = $sql;
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>