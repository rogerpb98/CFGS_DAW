// Main function
async function loadDropdown() {
    let select = document.getElementById("board-selector");
    fetch("../server/src/get-scenarios.php").then(function(response){
        if (response.ok) {
            return response.json();
        }
    })
    .then(function(data){
        let options=data;
        console.log(options);

        for (let i = 0; i < options.length; i++) {
            let optn = options[i];
            let el = document.createElement("option"); // Create element "option"
            el.textContent = optn; // Add each option from the array to said element every iteration
            el.value = optn;
            select.appendChild(el); // Append it inside the select element in html
        }
    });
}

/* Function that checks if the current selected element in the dropdown 
is an empty or random board and hides the divs to enter rows/columns */
let elem = document.getElementById("board-selector");
elem.onchange = function(){
    let hiddenDiv = document.getElementById("dimensions");
    console.log(elem.value);
    hiddenDiv.style.visibility = (this.value=="Empty Board" || this.value=="Random Board")
    ? "visible" : "hidden";
};