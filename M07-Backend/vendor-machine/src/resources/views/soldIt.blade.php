<!DOCTYPE html>
<html lang="{{str_replace('_','-',app()->getLocale())}}">
    <head > <script>
        setTimeout(() => {
  window.location.replace('/login');
}, "5000")

    </script>
        <meta charset="utf-8">
        <meta name="viewport"content="width=device-width,initial-scale=1">
        <title>Venut</title>
        @include('partials.nav')
        <h4> PRODUCTE VENUT A {{ auth()->user()->name }} </h4>


        <H3>REDIRECCIONANT....</H3>



    </head>
    <body>
    </body>
</html>
