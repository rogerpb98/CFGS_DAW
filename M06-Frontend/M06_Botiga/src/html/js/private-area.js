import {validateInput} from '../js/util/form.js';
import * as rest from '../js/util/rest.js';
import * as extras from '../js/util/table.js';

window.onload = main;

async function main (){

	const username = localStorage.getItem("username");

	if (username){
		// alert("show private data");
		rest.getProductsUser(username, (res) => {
			console.log(res);
			extras.printList(res);
		});
		$('#addProductModal').modal('show');
	} else {
		$('#login').modal('show');
	}
	// TODO: Authenticate user
	// TODO: Create session data
	// TODO: Show products filtered by user
	
	document.getElementById("register").addEventListener("click",onRegister);
	document.getElementById("addProductModal").addEventListener("click",onAddProduct);
	
	document.getElementById("logout").addEventListener("click",onLogout);
	
	document.getElementById("addProductSubmit").addEventListener("click",onAddProductSubmit);
	document.getElementById("inputName").addEventListener("blur",validateProductName);
	document.getElementById("inputDescription").addEventListener("blur",validateProductDescription);
	document.getElementById("inputPrice").addEventListener("blur",validateProductPrice);
	
	document.getElementById("submitloginUser").addEventListener("click", onSubmitLogin);
	document.getElementById("submitRegisterUser").addEventListener("click", onSubmitRegister);
	
}
function onRegister(){
	$('#login').modal('hide');
	$('#registerModal').modal('show');
}
function onSubmitLogin(e){

	const user = document.getElementById("inputUser").value;
	const password = String(CryptoJS.MD5(document.getElementById("inputPass").value));

	rest.login(user, password, (res_login) => {
		// show private data
		if (res_login.success){
			localStorage.setItem("username", user);
			// alert("show private data");
			$('#addProductModal').modal('show');
		} else {
			alert("login error");
		}
	})
	e.preventDefault();
	$('#login').modal('hide');

}
function onSubmitRegister(e){

	const email = document.getElementById("inputEmail").value;
	const password = String(CryptoJS.MD5(document.getElementById("inputPass").value));
	const lname = document.getElementById("inputName").value;
	const name = document.getElementById("inputLname").value;
	const adress = document.getElementById("inputAdress").value;

	rest.register(email, password, lname, name, adress, (res_register) => {
		// show private data
		if (res_register.success){
			localStorage.setItem("username", email);
			// alert("show private data");
			$('#addProductModal').modal('show');
		} else {
			alert("register error");
		}
	})
	e.preventDefault();
	$('#registerModal').modal('hide');

}

function onLogout(){
	// TODO: Remove session data
	localStorage.setItem("username","");
	window.close();
}

function onAddProduct(){
	// TODO: get categories and show them in form
}

function onAddProductSubmit(e){

	if (validateProductName() && validateProductDescription() && validateProductPrice()){
		submitProduct();
	} else {
		e.preventDefault();
	}

}

function submitProduct(){

	let product = {};

	let file = document.getElementById("inputImage").files[0];

	let img = file ? "http://localhost:9000/img/"+file.name : "";

	product.name = document.getElementById("inputName").value;
	product.description = document.getElementById("inputDescription").value;
	product.price = document.getElementById("inputPrice").value;
	product.category = document.getElementById("category").value;
	product.img = img;
	const username = localStorage.getItem("username");
	product.owner = username;

	// console.log(product);
	
	if (file){
		console.log("File found")
		rest.uploadImg(file, product, () => {
			rest.addProduct(product, (res) => {
				console.log("Add product ? "+res.success);
			});		
		})
	} else {
		console.log("File not found")
		rest.addProduct(product, (res) => {
			console.log("Add product ? "+res.success);
		});	
	}
}

function validateProductName(){

	var inputName = document.getElementById("inputName");
    return validateInput(inputName,"El nom no pot estar buit");
} 

function validateProductDescription(){

	var inputDescription = document.getElementById("inputDescription");
    return validateInput(inputDescription,"La descripció no pot estar buida");
} 

function validateProductPrice(){

	let inputPrice = document.getElementById("inputPrice");
    return validateInput(inputPrice,"El preu ha de ser mes gran que 0 i mes petit que 100000",(price) => {
		return (parseInt(price) > 0 && parseInt(price) < 1000000)
	})
}