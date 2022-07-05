// COMMON FUNCTIONS

export function validateInput(input,err_message,isInputValid){

    let is_input_valid = arguments.length > 2 ? isInputValid(input.value) : true;

    if (input.value && is_input_valid){
        setSuccess(input);
        return true;
    } 
    setError(input,err_message);
    return false;
}

function setSuccess(input){
	input.className = "form-control is-valid";
}

function setError(input, message){

    input.className = "form-control is-invalid";
    input.nextElementSibling.innerHTML = message;
}

// VALIDACION DE DATOS

function isValidDNI(dni){

    const re = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]{1}$/g;

    if (!re.test(dni)) return false;

    // Check last letter
    let lastLetter = dni.substr(dni.length-1, dni.lenght);
    let index = parseInt(dni.substr(0, 8)) % 23;

    const dniLetters = 'TRWAGMYFPDXBNJZSQVHLCKET';
    if (dniLetters.charAt(index) == lastLetter) return true;

    return false;
}

function isValidEmail(email){

    const re = /^\w+(\.\w+)*@\w+(\.\w+){1,2}$/g;
    return re.test(email);
}

function isValidPhone(phone){

    const re = /^[^0]\d{8}$/g;
    return re.test(phone);
}

		