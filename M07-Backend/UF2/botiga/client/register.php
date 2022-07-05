<!DOCTYPE html>
<html lang="es">
<?php
    $title = "Register";
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
            <h3>Register</h3>
            <br>
            <p>User *</p><input type="text" id="user" name="user">
            <p>Password *</p><input type="text" id="pwd" name="pwd">
            <p>Nombre *</p><input type="text" id="nombre" name="nombre">
            <p>Apellido</p><input type="text" id="apellido" name="apellido">
            <div id="btns">
                <a href="login.php" class="header-user">Login</a>
                <button class="header-user" onclick="registerUser()">Register</button>
            </div>
            <a href="productos.php">Volver a productos</a>
        </div>
    </main>
</body>
</html>