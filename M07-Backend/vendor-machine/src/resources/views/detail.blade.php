<!DOCTYPE html>
<html lang="{{str_replace('_','-',app()->getLocale())}}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport"content="width=device-width,initial-scale=1">
        <title>Shop</title>
        @include('partials.nav')
        <h4>Benvingut {{ auth()->user()->name }} </h4>
        <h4>Balanç: {{ auth()->user()->balance }} € </h4>
        <h1>Productes</h1>
        <div id="{{$product->id}}" class="product">
            <img src="{{'/images/'.$product->img }}" alt="" style="width: 500px; height=500px; overflow: cover">
            <h1>PREU: {{$product->preu}}</h1>
            <h2>Informació adicional</h2>
            <ul>
                <li>Procedencia: {{$product->procedencia}}</li>
                <li>Kc per unitat: {{$product->kcud}}</li>
                <li>Kc per cada 100g: {{$product->kg100g}}</li>
                <li>Greixos: {{$product->greixos}}</li>
                <li>Carbohidrats: {{$product->carbohidrats}}</li>
                <li>Proteines: {{$product->proteines}}</li>
            </ul>
            <a class="link" href="buy/{{ $product->id }}">Comprar</a
        </div>

    </head>
    <body>
    </body>
</html>
