<header>
    <?php 
    session_start();
    //Log out / Register
    echo (isset($_SESSION['user'])) ? '<a href="logout.php" class="header-user">Log Out</a>' : '<a href="register.php" class="header-user">Register</a>' ;
    //Log In / Username
    echo (isset($_SESSION['user'])) ? '<p class="header-user" id="username">'.$_SESSION['user'].'</p>' : '<a href="login.php" class="header-user">Login</a>' ;
    // "" / Add item
    echo (isset($_SESSION['user'])) ? '<a href="addProduct.php" class="header-user">Añadir producto</a>' : '' ;
    ?>
</header>