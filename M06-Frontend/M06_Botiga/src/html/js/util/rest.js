// FUNCTIONS USER

export function login(user, password, callback){

	$.ajax({
        url: "user/login",
        method: "POST",
        dataType: "json",
        data: { "user": user,
                "password" : password}
    }).done(callback);

}

export function register(email, password, name, lname, adress, callback){

	$.ajax({
        url: "user/register",
        method: "POST",
        dataType: "json",
        data: { 
			"email": email,
            "pwd" : password,
			"name" : name,
			"lname" : lname,
			"adress" : adress,
			}
    }).done(callback);

}

// FUNCTIONS PRODUCT

export function addProduct(product, callback){

	$.ajax({
		url: "/product/add",
		method: "POST",
		datatype: "json",
		data: {
			"owner" : product.owner,
			"product_name" : product.name,
			"description" : product.description,
			"price" : product.price,
			"category" : product.category,
			"img" : product.img,

		}
	}).done(callback);

}

export function getProducts(callback){

	$.ajax({
		url: "/product/list",
		method: "GET",
		datatype: "json",
		data: product
	}).done(callback);

}

export function getProductsID(id, callback){

	$.ajax({
		url: `/product/list/${id}`,
		method: "GET",
		datatype: "json",
		data: product
	}).done(callback);

}

export function getProductsUser(email_owner, callback){

	$.ajax({
		url: `/product/list/owner/${email_owner}`,
		method: "GET",
		datatype: "json",
	}).done(callback);

}

export function uploadImg(file, product, callback){
	
	let fd = new FormData();
	fd.append("productFile", file);

	$.ajax({
		url: "/product/upload-file",
		method: "POST",
		data: fd,
		processData: false,  // tell jQuery not to process the data
		contentType: false   // tell jQuery not to set contentType	  
	}).done(callback);

}

