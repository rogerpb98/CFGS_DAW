let characters = [
    {name: "Harry Potter", actor: "Daniel Radcliffe", house: "Gryffindor", yearOfBirth: "1980", eyeColour: "green", hairColour: "black"},
    {name: "Hermione Granger", actor: "Emma Watson", house: "Gryffindor", yearOfBirth: "1979", eyeColour: "brown", hairColour: "brown"},
    {name: "Ron Weasley", actor: "Rupert Grint", house: "Gryffindor", yearOfBirth: "1980", eyeColour: "blue", hairColour: "red"},
    {name: "Draco Malfoy", actor: "Tom Felton", house: "Slytherin", yearOfBirth: "1980", eyeColour: "grey", hairColour: "blonde"},
    {name: "Minerva McGonagall", actor: "Dame Maggie Smith", house: "Gryffindor", yearOfBirth: "1925", eyeColour: "", hairColour: "black"},
    {name: "Cedric Diggory", actor: "Robert Pattinson", house: "Hufflepuff", yearOfBirth: "1977", eyeColour: "grey", hairColour: "brown"},
    {name: "Cho Chang", actor: "Katie Leung", house: "Ravenclaw", yearOfBirth: "", eyeColour: "brown", hairColour: "black"},
    {name: "Severus Snape", actor: "Alan Rickman", house: "Slytherin", yearOfBirth: "1960", eyeColour: "black", hairColour: "black"},
    {name: "Rubeus Hagrid", actor: "Robbie Coltrane", house: "Gryffindor", yearOfBirth: "1928", eyeColour: "black", hairColour: "black"},
    {name: "Neville Longbottom", actor: "Matthew Lewis", house: "Gryffindor", yearOfBirth: "1980", eyeColour: "", hairColour: "blonde"},
    {name: "Luna Lovegood", actor: "Evanna Lynch", house: "Ravenclaw", yearOfBirth: "1981", eyeColour: "grey", hairColour: "blonde"},
    {name: "Ginny Weasley", actor: "Bonnie Wright", house: "Gryffindor", yearOfBirth: "1981", eyeColour: "brown", hairColour: "red"},
    {name: "Sirius Black", actor: "Gary Oldman", house: "Gryffindor", yearOfBirth: "1959", eyeColour: "grey", hairColour: "black"},
    {name: "Remus Lupin", actor: "David Thewlis", house: "Gryffindor", yearOfBirth: "1960", eyeColour: "green", hairColour: "brown"},
    {name: "Arthur Weasley", actor: "Mark Williams", house: "Gryffindor", yearOfBirth: "1950", eyeColour: "blue", hairColour: "red"},
    {name: "Bellatrix Lestrange", actor: "Helena Bonham Carter", house: "Slytherin", yearOfBirth: "1951", eyeColour: "brown", hairColour: "black"},
    {name: "Lord Voldemort", actor: "Ralph Fiennes", house: "Slytherin", yearOfBirth: "1926", eyeColour: "red", hairColour: "bald"}
]
lista = [];
function duplicarArray(array) {
	array.forEach(element => {
		//console.log(element);
		lista.push(element);
	});
}
duplicarArray(characters);
function filterList(array, cadena, year) {
    if (!cadena && !year) return characters;
    if (cadena && year) {
        return array.filter(item => {
            if (item.house.startsWith(cadena) && item.yearOfBirth < year) return true;
        });
    }
    else if(!cadena) {
        return array.filter(item => {
            if (item.yearOfBirth < year) return true;
        });
    }
    else if (!year) {
        return array.filter(item => {
            if (item.house.startsWith(cadena)) return true;
        });
    }
    return characters;
}
function filtrar() {
	busqueda = document.getElementById("casa").value;
    born = document.getElementById("year").value;
	lista = filterList(characters, busqueda, born);
	printList(lista);
	//console.log(array);
}
function orderList(array, orden) {
	function compareASC(a, b) {
		if ( a.house < b.house ){
			return -1;
		  }
        if ( a.house == b.house ){
            if (a.name < b.name) return -1;
            return 1;
        }
		return 1;
	}
	function compareDESC(a, b) {
		if ( a.house > b.house ){
			return -1;
		  }
        if ( a.house == b.house ){
            if (a.name > b.name) return -1;
            return 1;
        }
		return 1;
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
function addRow(character) {
	//name, id, nametype, recclass, mass, fall, year, reclat, reclong, geolocation
	return `<tr>
		<td>${character.name}</td>
		<td>${character.actor}</td>
		<td>${character.house}</td>
		<td>${character.yearOfBirth}</td>
		<td>${character.eyeColour}</td>
		<td>${character.hairColour}</td>
	</tr>`;
}

function printList(array) {
	tabla = "<table><thead><tr><th>name</th><th>actor</th><th>house</th><th>yearOfBirth</th><th>eyeColour</th><th>hairColour</th></tr></thead><tbody>";
	array.forEach(character => {
		tabla += addRow(character);
	});
	tabla += "</tbody></table>";
	document.getElementById('llistat').innerHTML=tabla;
}