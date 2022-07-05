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
        <div class="products" style=" display: flex; gap: 20px; flex-wrap:wrap">
            @foreach ($products as $product)
                <a class="item" href="product/{{ $product->id }}">
                    <img src="{{'/images/'.$product->img }}" alt="" style="width: 200px; height=200px">
                    <h2>Preu: {{ $product->preu }}</h2>
                </a>
            @endforeach
        </div>


    </head>
    <body>
    </body>
</html>
