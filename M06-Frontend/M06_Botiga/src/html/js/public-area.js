window.onload = main;

let products;
let lista=[];

async function main (){

	products = await recogerDatos();
	duplicarArray(products);
	document.getElementById("login").addEventListener("click",onLogin);
	document.getElementById("reload").addEventListener("click",recargar);
	document.getElementById("search").addEventListener("click",filtrar);

	printList(products);

	
}

function duplicarArray(array) {
	array.forEach(element => {
		//console.log(element);
		lista.push(element);
	});
}
function onLogin(){
	window.open("private-area.html");
}
function recargar() {
	location.reload();
}
function filtrar() {
	busqueda = document.getElementById("filtro").value;
	lista = filterList(products, busqueda);
	printList(lista);
}
function filterList(array, cadena) {
	return array.filter(item => {
		if (item.product_name.toLowerCase().startsWith(cadena.toLowerCase())) return true;
	});
}

async function recogerDatos() {
	const response = await fetch("http://localhost:9000/product/list");
	const data = await response.json();
	return data;
}

function printList(array) {
	// tabla="<table><thead><tr><th>id</th><th>Name</th><th>Details</th></tr></thead>";
	tabla="<thead><tr><th>id</th><th>Name</th><th>Details</th></tr></thead>";
	array.forEach(element => {
		tabla+=""
		+"<tbody>"
		+"<tr id='"+element.product_id+"'>"
			+"<td id='celda-id'>"+element.product_id+"</td>"
			+"<td id='celda-nombre'>"+element.product_name+"</td>"
			+"<td><button id='myBtn' onclick='mostrarModal("+element.product_id+")'>Detalles</button></td>"
		+"</tr>"
		+"</tbody>";
	});
	// tabla+="</table>";
	document.getElementById('c-main__table').innerHTML=tabla;
}

async function mostrarModal(id) {
	const response = await fetch(`http://localhost:9000/product/list/${id}`);
	const data = await response.json();
	item = data[0];
	console.log(item);
	modal = ''
	+'<div class="modal fade" id="myModal" role="dialog">'
		+'<div class="modal-dialog">'
			+'<div class="modal-content">'
				+'<div class="modal-header">'
					+'<div>'
						+`<h4>${item.product_name}</h2>`
					+'</div>'
					+'<button type="button" class="close" data-dismiss="modal">&times;</button>'
				+'</div>'
				+'<div class="modal-body">'
					+`<p>Product id: ${item.product_id}</p>`
					+`<p>Category: ${item.category}</p>`
					+`<p>Description: ${item.description}</p>`
					+`<p>Price: ${item.price}</p>`
					+`<p>Seller: ${item.email_owner}</p>`
					+`<img src="img/${item.img}"/ alt="Imagen del producto">`
				+'</div>'
			+'</div>'
		+'</div>'
	+'</div>'
	$(modal).modal();
}