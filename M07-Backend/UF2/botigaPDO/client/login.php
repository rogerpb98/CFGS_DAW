<!DOCTYPE html>
<html lang="es">
<?php
    $title = "Login";
    include 'templates/head.php';
?>
<body>
    <?php
    session_start();
    if (isset($_SESSION['user'])) {
        header("Location: productos.php"); 
        exit();
    }
    ?>
    <main class="log-reg-main">
        <div>
            <h3>Login</h3>
            <br>
            <p>User</p><input type="text" id="user" name="user">
            <p>Password</p><input type="text" id="pwd" name="pwd">
            <div id="btns">
                <button class="header-user" onclick="loginUser()">Login</button>
                <a href="register.php" class="header-user">Register</a>
            </div>
            <a href="productos.php">Volver a productos</a>
        </div>
    </main>
</body>
</html>