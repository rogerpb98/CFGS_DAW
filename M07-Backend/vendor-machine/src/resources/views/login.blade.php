<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Login</title>
    @include('partials.nav')
    <h1>Login</h1>
</head>

<body>
    <form method="POST">
        @csrf
        <label>
            <input name='name' type="tect" placeholder="Nom...">
        </label><br>
        <label>
            <input name='password' type="password" placeholder="Contrasenya...">
        </label><br>
                <button type="submit"> Login </button>
    </form>
</body>

</html>
