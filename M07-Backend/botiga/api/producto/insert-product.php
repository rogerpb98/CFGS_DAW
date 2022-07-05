<?php
//curl -X PUT -d '{"user":"antonia44", "nombre": "articulo1", "categoria": "Juegos", "precio": "10.50", "desc": "descripcion 123", "fotos": []}' localhost/M07/UF2/botiga/api/producto/insert-product.php
//curl -X PUT -d '{"user":"antonia44", "nombre": "articulo1", "categoria": "Juegos", "precio": "10.50", "desc": "descripcion 123", "fotos": ["foto1"]}' localhost/M07/UF2/botiga/api/producto/insert-product.php
//curl -X PUT -d '{"user":"antonia44", "nombre": "articulo1", "categoria": "Juegos", "precio": "10.50", "desc": "descripcion 123", "fotos": ["foto1", "foto2"]}' localhost/M07/UF2/botiga/api/producto/insert-product.php
//curl -X PUT -d '{"user":"antonia44", "nombre": "articulo1", "categoria": "Juegos", "precio": "10.50", "desc": "descripcion 123", "fotos": ["foto1", "foto2", "foto3"]}' localhost/M07/UF2/botiga/api/producto/insert-product.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "PUT") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $user = $data["user"];

    $nombre = $data["nombre"];
    $categoria = $data["categoria"];
    $desc = $data["desc"];
    $precio = $data["precio"];
    $fotos = $data["fotos"];

    $sql;
    switch (count($fotos)) {
        //si no hay fotos
        case 0:
            $sql = $con->prepare("INSERT INTO PRODUCTO (CLIENTE_USER, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO) VALUES(?, ?, ?, ?, ?)");
            $sql->bind_param("ssssd",$user, $nombre,$categoria,$desc,$precio);
            //$sql = "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA, DESCRIPCION, PRECIO) VALUES('".$nombre."', '".$categoria."', '".$desc."', '".$precio."')";
            break;
        //si hay fotos
        case 1:
            $sql = $con->prepare("INSERT INTO PRODUCTO (CLIENTE_USER, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1) VALUES(?, ?, ?, ?, ?, ?)");
            $sql->bind_param("ssssds",$user, $nombre,$categoria,$desc,$precio,$fotos[0]);
            //$sql = "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1) VALUES('".$nombre."', '".$categoria."', '".$desc."', '".$precio."', '".$fotos[0]."')";
            break;
        case 2:
            $sql = $con->prepare("INSERT INTO PRODUCTO (CLIENTE_USER, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, FOTO2) VALUES(?, ?, ?, ?, ?, ?, ?)");
            $sql->bind_param("ssssdss",$user, $nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1]);
            //$sql = "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, FOTO2) VALUES('".$nombre."', '".$categoria."', '".$desc."', '".$precio."', '".$fotos[0]."', '".$fotos[1]."')";
            break;
        case 3:
            $sql = $con->prepare("INSERT INTO PRODUCTO (CLIENTE_USER, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, FOTO2, FOTO3) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            $sql->bind_param("ssssdsss",$user, $nombre,$categoria,$desc,$precio,$fotos[0],$fotos[1],$fotos[2]);
            //$sql = "INSERT INTO PRODUCTO (NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, FOTO2, FOTO3) VALUES('".$nombre."', '".$categoria."', '".$desc."', '".$precio."', '".$fotos[0]."', '".$fotos[1]."', '".$fotos[2]."')";
            break;
    }
    
    $sql->execute();
    if (!($sql->affected_rows===0)) {
        $response["message"] = "OK";
        $response["user"] = $user;

        $response["nombre"] = $nombre;
        $response["categoria"] = $categoria;
        $response["desc"] = $desc;
        $response["precio"] = $precio;
        $response["fotos"] = $fotos;
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>