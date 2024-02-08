let contenitore = document.getElementById('container');
let button = document.getElementById('bottone');
let numeriUsciti = document.getElementById('numeriusciti')
let arrayNumeriUsciti = [];
let numeriSpan = []
function numeriInTabella() {
    let numeroInSpan = 1;
    for (i = 0; i < 9; i++) {
        let span = document.createElement('span');
        contenitore.appendChild(span);
        for (k = 0; k < 10; k++) {
            if (numeroInSpan <= 90) {
                numeriSpan.push(numeroInSpan);
                span.innerText += `[${numeroInSpan}]  `
                numeroInSpan++;
                

            } else {
                break;
            }
        }
    }

}

numeriInTabella();

button.addEventListener('click', () => {
    let random = Math.floor(Math.random() * 90);
    let p = document.createElement('p');
    arrayNumeriUsciti.push(random);
    p.innerText = random;
    numeriUsciti.appendChild(p);
    confronta();
})



const confronta = () => {
    arrayNumeriUsciti.forEach(numero => {
        let span = document.querySelector('span'); 
        if (span) {
            span.classList.add('rosso');
        }
    });
}