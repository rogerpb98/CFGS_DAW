<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .error {color: #FF0000;}
    </style>
</head>
<body>
    <?php
    if (isset($_COOKIE['user']) && isset($_COOKIE['password'])) {
        header("Location: tenda.php"); 
        exit();
    }
    ?>
    <!---------------------------------------------------->
    <form method="post" action="validacio.php">
        user:
        <input type="text" id="user" name="user">
        <br><br>
        passwd:
        <input type="password" id="pwd" name="pwd">
        <br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
