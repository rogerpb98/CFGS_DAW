<!DOCTYPE html>
<html lang="es">
<head>
<title>VideoClub</title>
<meta charset="UTF-8">
<style>
    .header{
    background-color: #2175bc;
    }
    ul {
    margin: 0;
    padding: 10px;
    }
    ul li {
    display: inline;
    }
    ul li a {
    font-family: Arial;
    font-size: 11px;
    text-decoration: none;
    padding: 10px;
    background-color: #2175bc;
    color: #fff;
    }
</style>
</head>
<body>
    <div class='header'>
        <h1>Video Club</h1>
        <nav>
        <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/llista">Llistat</a></li>
        <li><a href="/contactar">Contacta</a></li>
        </ul>
        </nav>
    </div>
    @yield('principal')
</body>
</html>
