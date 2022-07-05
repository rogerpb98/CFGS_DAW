let lista = [];
let fallStats = [
	{
		state: "Fell",
		count: 0
	},
	{
		state: "Found",
		count: 0
	},
	{
		state: "Others",
		count: 0
	}
];
let weightStats = [
	{
		type: "Light",
		count: 0
	},
	{
		type: "Medium",
		count: 0
	},
	{
		type: "Heavy",
		count: 0
	},
	{
		type: "Others",
		count: 0
	}
]
function countWeigths(meteorite) {
	let mass=(meteorite.mass) ? parseInt(meteorite.mass) : null ;
	
	if (mass<=1000) {
		weightStats[0].count++;
	} else if (mass>1000 && mass <=100000) {
		weightStats[1].count++;
	} else if (mass>100000) {
		weightStats[2].count++;
	} else {
		weightStats[3].count++;
	}
}
function countFalls(meteorite) {
	if (meteorite.fall==="Fell") {
		fallStats[0].count++;
	} else if (meteorite.fall==="Found") {
		fallStats[1].count++;
	} else {
		fallStats[2].count++;
	}
}
function masaMitja(total) {
	mitja = total/lista.length;
	return mitja;
}
function updateResults(total) {
	document.getElementById("quantitat").innerHTML=lista.length;
	document.getElementById("mass").innerHTML=total/1000;
	document.getElementById("mitjana").innerHTML=masaMitja(total);
}
function addRow(meteorite) {
	geo = meteorite.geolocation;
	coords = (geo==undefined) ? "" : `${geo.latitude},${geo.longitude}` ;
	year = (meteorite.year==undefined) ? "" : (meteorite.year).substring(0,4) ;
	//name, id, nametype, recclass, mass, fall, year, reclat, reclong, geolocation
	return `<tr id='${meteorite.id}'>
		<td class="wide">${meteorite.name}</td>
		<td>${meteorite.id}</td>
		<td>${meteorite.nametype}</td>
		<td class="wide">${meteorite.recclass}</td>
		<td>${meteorite.mass}</td>
		<td>${meteorite.fall}</td>
		<td>${year}</td>
		<td class="wide">${meteorite.reclat}</td>
		<td class="wide">${meteorite.reclong}</td>
		<td class="wide">(${coords})</td>
	</tr>`;
}
function addThead() {
	return `<thead>
		<tr>
			<th class="wide">name</th>
			<th>id</th>
			<th>nametype</th>
			<th class="wide">recclass</th>
			<th>mass (g)</th>
			<th>fall</th>
			<th>year</th>
			<th class="wide">reclat</th>
			<th class="wide">reclong</th>
			<th class="wide">GeoLocation</th>
		</tr>
	</thead>`;
}
function procesarDatos(meteoritos) {
	tabla = "<table>"+addThead()+"<tbody>";
	totalMass=0;
	meteoritos.forEach(meteorito => {
		// Add tr (row) of each meteorite with its info
		tabla += addRow(meteorito);
		// Add current meteorite mass to the total
		totalMass+=(meteorito.mass) ? parseInt(meteorito.mass) : 0 ;
		// Add marker on the map for current meteorite
		addMarker(meteorito);
		// Add to counter of respective category
		countFalls(meteorito);
		countWeigths(meteorito);
	});
	tabla += "</tbody></table>";
	updateResults(totalMass);
	document.getElementById('llistat').innerHTML=tabla;
}
async function loadData() {
	var url = "https://data.nasa.gov/resource/gh4g-9sfh.json?$limit=500";
	//98pdyv88e4jcvolxfiwufkw39
	try {
		const response = await fetch(url);
		//console.log(response); //promesa
		lista = await response.json();

		procesarDatos(lista);
		
		fallchart();
		weightchart();
	} catch (error) {
		console.log(error);
	}
}
function recargar() {
	location.reload();
}