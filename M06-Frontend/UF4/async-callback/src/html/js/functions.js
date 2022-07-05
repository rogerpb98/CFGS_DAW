window.onload = main;

async function main (){

	// Quiero hacer getCategories, coger la primera categoria
	// y hacer getProducts de esa categoria, coger el primer
	// producto y hacer getUser del primer producto

	categories = await getCategories();
	console.log(categories);
	products = await getProducts(categories[0]);
	console.log(products);
	users = await getUser(products[0].email);
	console.log(users);

}

async function getCategories(){

	try {
		const response = await fetch("http://localhost:9000/category/list", {
			method: "GET",
			headers: {
				'Content-Type': 'application/json'
			}
		});
		let datos = await response.json()
		return datos;
	} catch (error) {
		return error;
	}
}

async function getProducts(category){

	try {
		const response = await fetch(`http://localhost:9000/product/list?category=${category}`, {
			method: "GET",
			headers: {
				'Content-Type': 'application/json'
			}
		});
		let datos = await response.json()
		return datos;
	} catch (error) {
		return error;
	}
}

async function getUser(username){

	try {
		const response = await fetch(`http://localhost:9000/user/get?username=${username}`, {
			method: "GET",
			headers: {
				'Content-Type': 'application/json'
			}
		});
		let datos = await response.json()
		return datos;
	} catch (error) {
		return error;
	}
}
