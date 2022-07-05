<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="post" action="prova.php">
        <label for="user">Usuario:</label>
        <input type="text" id="user" name="user" pattern="\w*" placeholder="rogerpb98" required><br>
        <label for="passwd">Contraseña:</label>
        <input type="text" id="passwd" name="passwd" pattern="\w*" placeholder="contraseña123" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>