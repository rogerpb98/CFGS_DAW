const titles = document.getElementsByTagName("h1");
console.log(titles);
console.log(titles[0].innerHTML);
const titulo1=titles[0];
const body = titulo1.parentElement;
console.log(body);
console.log(body.children);
children = body.children;
console.log(children.length);
console.log(children[1]);
for (let i = 0; i < children.length; i++) {
    const element = array[i];
    console.log(element);
}