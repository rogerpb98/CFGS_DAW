<a href="/"> Inici </a>
@auth
<a href="/products">Productes </a>

<form action="login" method="post">
@method('put')
@csrf
<button>Logout</button>
</form>


@else
<a href="/login"> Login </a>
@endauth
