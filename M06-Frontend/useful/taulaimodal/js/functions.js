let pokemons;
let lista = [];
function printList(array) {
	tabla="<table><thead><tr><th>ID</th><th>Imagen</th><th>Nombre</th><th>Altura</th><th>Peso</th></tr></thead>";
	array.forEach(pokemon => {
		tabla+=""
		+"<tbody>"
		+"<tr id='"+pokemon.id+"'>"
			+"<td id='celda-id'>"+(pokemon.id).toString().padStart(3, '0')+"</td>"
			+"<td id='celda-imagen'><img src='"+pokemon.img+"'/></td>"
			+"<td>"+pokemon.name+"</td>"
			+"<td id='celda-altura'>"+pokemon.height+"</td>"
			+"<td id='celda-peso'>"+pokemon.weight+"</td>"
			+"<td><button id='myBtn' onclick='mostrarModal("+(pokemon.id-1)+")'>Detalles</button></td>"
		+"</tr>"
		+"</tbody>";
	});
	tabla+="</table>";
	document.getElementById('llistat').innerHTML=tabla;
}
function duplicarArray(array) {
	array.forEach(element => {
		//console.log(element);
		lista.push(element);
	});
}
async function recollirPokemons() {
	var urlPokemon = "js/data/pokemon.json";
	try {
		const response = await fetch(urlPokemon);
		//console.log(response); //promesa
		const datos = await response.json();
		//console.log(datos); //objeto pokemons
		//console.log(datos.pokemon); //array pokemons
		pokemons = datos.pokemon;
		duplicarArray(pokemons);
		printList(lista);
		/*
		Propiedades:
		id, num, name, avg_spawns, candy, candy_count, egg, height,img, multipliers[], next_evolution spawn_chance, spawn_time, type[], weaknesses, weight
		*/
	} catch (error) {
		console.log(error);
	}
}
function orderList(array, orden) {
	function compareASC(a, b) {
		if ( a.name < b.name ){
			return -1;
		  }
		if ( a.name > b.name ){
			return 1;
		  }
		return 0;
	}
	function compareDESC(a, b) {
		if ( a.name > b.name ){
			return -1;
		  }
		if ( a.name < b.name ){
			return 1;
		  }
		return 0;
	}
	if (orden==="asc") {
		array.sort(compareASC);
		printList(array);
	} else if (orden==="desc") {
		array.sort(compareDESC);
		printList(array);
	} else {
		console.log("Orden incorrecto");
	}
}
function filtrar() {
	busqueda = document.getElementById("filtro").value;
	lista = filterList(pokemons, busqueda);
	printList(lista);
	//console.log(array);
}
function filterList(array, cadena) {
	return array.filter(item => {
		if (item.name.startsWith(cadena)) return true;
	});
}
function calcMitjana() {
	total=0;
	peso=0;
	pokemons.forEach(pokemon => {
		peso=parseInt(pokemon.weight.substring(-3)); //extrae el " kg" del peso
		total+=peso;
	});
	mitjana=(total/pokemons.length).toFixed(2);
	document.getElementById('mitjana').innerHTML=mitjana;
}
function recargar() {
	location.reload();
}
function mostrarModal(id) {
	console.log(id);
	modal = ''
	+'<div class="modal fade" id="myModal" role="dialog">'
		+'<div class="modal-dialog">'
			+'<div class="modal-content">'
				+'<div class="modal-header">'
					+'<button type="button" class="close" data-dismiss="modal">&times;</button>'
					+'<div>'
						+'<img src="'+pokemons[id].img+'" class="modal-image"/>'
						+'<h4 class="modal-title">'+pokemons[id].name+'</h4>'
					+'</div>'
				+'</div>'
				+'<div class="modal-body">'
					+'<p>Nom : '+pokemons[id].name+'</p>'
					+'<p>pes : '+pokemons[id].weight+'</p>'
				+'</div>'
			+'</div>'
		+'</div>'
	+'</div>'
	$(modal).modal();
}