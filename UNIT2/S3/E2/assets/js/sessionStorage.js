document.addEventListener('DOMContentLoaded', () => {
const contenitore = document.getElementById('container')
let p = document.createElement('p');
contenitore.appendChild(p);

function contatore() {
    let time = parseInt(sessionStorage.getItem('numero')) || 0;
    sessionStorage.setItem('numero', time + 1);
    p.innerText = time + 1;
}
setInterval(contatore,1000)
} )