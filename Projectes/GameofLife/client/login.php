<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body{
            width: fit-content;
            margin:auto;
            margin-top: 126px;

        }
        h1{
            margin:auto;
        }
    </style>
</head>
<body>
    <div id="content">
        <h1>LOGIN</h1>
        <?php
        if (isset($_COOKIE['user'])) {
            header("Location: index.php"); 
            exit();
        }
        ?>
        <form method="POST" action="../server/src/loginUsers.php">
            <p>User: <input type="text" name="user" size="20"></p>
            <p>Password: <input type="password" name="password" size="15"></p>
            <p><input type="submit" value="Entrar" name="B1"></p>
        </form>
        <a href="register.php">Are you a new user?</a>
    </div>
</body>
</html> 