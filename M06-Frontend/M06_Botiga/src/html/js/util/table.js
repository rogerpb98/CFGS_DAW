export function printList(array) {
    // tabla="<table><thead><tr><th>id</th><th>Name</th><th>Details</th></tr></thead>";
	let tabla="<thead><tr><th>id</th><th>Name</th><th>Price</th></tr></thead>";
	array.forEach(element => {
		tabla+=""
		+"<tbody>"
		+"<tr id='"+element.product_id+"'>"
			+"<td id='celda-id'>"+element.product_id+"</td>"
			+"<td id='celda-nombre'>"+element.product_name+"</td>"
			+"<td id='celda-price'>"+element.price+"</td>"
		+"</tr>"
		+"</tbody>";
	});
	// tabla+="</table>";
	document.getElementById('c-main__table').innerHTML=tabla;
}
