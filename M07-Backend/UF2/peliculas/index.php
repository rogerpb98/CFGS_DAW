<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        async function insertPeli() {
            data = {
                "id": document.getElementById("id").value,
                "titol": document.getElementById("titol").value,
                "any": document.getElementById("any").value
            };
            try {
                const response = await fetch("api/put.php", {
                    method: "PUT",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                });
                console.log(response);
            } catch (error) {
                console.log(error);
            } finally {
                location.reload();
            }
        }
        async function deletePeli() {
            data = {
                "id": document.getElementById("id").value
            };
            try {
                const response = await fetch("api/delete.php", {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                });
                console.log(response);
            } catch (error) {
                console.log(error);
            } finally {
                location.reload();
            }
        }
        async function modificaPeli() {
            data = {
                "id": document.getElementById("id").value,
                "titol": document.getElementById("titol").value,
                "any": document.getElementById("any").value
            };
            try {
                const response = await fetch("api/post.php", {
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                });
                console.log(response);
            } catch (error) {
                console.log(error);
            } finally {
                location.reload();
            }
        }
        async function detalls() {
            
        }
    </script>
</head>
<body>
    Id peli:  <input type="text" name="id" id="id">  <br>  
    Títol peli:  <input type="text" name="titol" id="titol">  <br>  
    Any peli:  <input type="text" name="any" id="any">  <br>  
    <button onclick=insertPeli()>Insert</button><br>
    <button onclick=deletePeli()>Delete</button><br>
    <button onclick=modificaPeli()>Update</button><br>
    
    <?php 
        $con = new mysqli();
        $con->connect('localhost','roger','roger','pelis');
        if (!$con) {
            printf("Connect failed: %s\n", $mysqli->connect_error);
            exit();
        }
        $resultado = $con->query("SELECT * FROM PELICULA");
        echo ("Num de pelis: ". $resultado->num_rows ."<hr>"); 
        while ($fila = $resultado->fetch_array()) { 
            echo $fila[0]." - ". $fila[1] ." (". $fila[2] .")<br />";
        };
        $con->close();
    ?>
</body>
</html>