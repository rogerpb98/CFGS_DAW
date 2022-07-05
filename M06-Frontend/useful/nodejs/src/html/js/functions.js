window.onload = main;

function main (){

	// getProducts((products) => {
	// 	console.log(products);
	// });

	document.getElementById("register").addEventListener("click",onRegister);
}

function onRegister(){
	user = {};
	user.user_name = document.getElementById("inputUser").value;
	user.password = document.getElementById("inputPassword").value;
	user.email = document.getElementById("inputEmail").value;
	console.log(user);
	register(user, (res) => {
		console.log("Registro respuesta = "+res.success);
		alert("Registro respuesta = "+res.success);
	});
}

function register(user, callback){

	$.ajax({
		url: "localhost:9000/user/register",
		method: "POST",
		datatype: "json",
		data: user
	}).done(callback);

}

// function getProducts(callback){

// 	$.ajax({
// 		url: "/product/list",
// 		method: "GET",
// 		datatype: "json",
// 		data: ""
// 	}).done(callback);

// }