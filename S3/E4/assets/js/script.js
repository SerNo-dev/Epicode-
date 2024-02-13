document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById('container');
    const numeriUsciti = document.getElementById('numeriusciti');
    const button = document.getElementById('bottone');
    let arrayNumeriUsciti = [];

    function numeriInTabella() {
        let numeroInSpan = 1;
        for (let i = 0; i < 9; i++) {
            let row = table.insertRow();
            for (let k = 0; k < 10; k++) {
                if (numeroInSpan <= 90) {
                    let cell = row.insertCell();
                    cell.textContent = numeroInSpan;
                    numeroInSpan++;
                } else {
                    break;
                }
            }
        }
    }

    numeriInTabella();

    button.addEventListener('click', () => {
        let random;
        do {
            random = Math.floor(Math.random() * 90 + 1);
        } while (arrayNumeriUsciti.includes(random));
        
        arrayNumeriUsciti.push(random);
        
        let p = document.createElement('p');
        p.textContent = random;
        numeriUsciti.appendChild(p);

        confronta(random);
    });

    function confronta(numero) {
        let rows = table.rows;
        for (let i = 0; i < rows.length; i++) {
            let cells = rows[i].cells;
            for (let j = 0; j < cells.length; j++) {
                if (cells[j].textContent === numero.toString()) {
                    cells[j].classList.add('rosso');
                }
            }
        }
    }
});
