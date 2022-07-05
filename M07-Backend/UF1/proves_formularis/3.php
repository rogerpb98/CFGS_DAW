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
    // define variables and set to empty values
    $userErr = $passwdErr = "";
    $user = $passwd = "";

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (empty($_POST["user"])) {
            $userErr = "User is required";
        } else {
            $user = test_input($_POST["user"]);

            if (!preg_match("\w{3,8}",$user)) {
                $userErr = "Usuario entre 3 y 8 caracteres";
            }
        }
        if (empty($_POST["passwd"])) {
            $passwdErr = "Password is required";
        } else {
            $passwd = test_input($_POST["passwd"]);
            if (!preg_match("\w{8,16}",$passwd)) {
                $passwdErr = "Usuario entre 8 y 16 caracteres";
            }
        }
    }

    function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
    }
    ?>
    <!---------------------------------------------------->
    <p><span class="error">* required field</span></p>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Usuario:
        <input type="text" id="user" name="user">
        <span class="error">* <?php echo $userErr;?></span>
        <br><br>
        Contraseña:
        <input type="text" id="passwd" name="passwd">
        <span class="error">* <?php echo $passwdErr;?></span>
        <br><br>
        <input type="submit" value="Submit">
    </form>
    <!---------------------------------------------------->
    <?php
    echo "<h2>Your Input:</h2>";
    echo $user;
    echo "<br>";
    echo $passwd;
    ?>
</body>
</html>
