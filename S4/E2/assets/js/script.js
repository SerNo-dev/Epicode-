let calendario = document.getElementById('calendario');
let data = new Date();
let mese = data.getMonth();
data.setDate(1);
let giorniDelMese = [];
let tabella = document.createElement('table');
let tbody = document.createElement('tbody');
let tabellaVisibile = false;

const giorni = () => {
    while (data.getMonth() === mese) {
        giorniDelMese.push(new Date(data));
        data.setDate(data.getDate() + 1);
    }
}

giorni();
console.log(giorniDelMese);

function mostraTabella() {
    tbody.innerHTML = '';
    let row = document.createElement('tr');
    for (let i = 0; i < giorniDelMese.length; i++) {
        let cell = document.createElement('td');
        cell.innerHTML = giorniDelMese[i].getDate();
        cell.classList.add('giorno');
        row.appendChild(cell);
        if ((i + 1) % 5 === 0 || i === giorniDelMese.length - 1) {
            tbody.appendChild(row);
            row = document.createElement('tr');
        }
    }
    tabella.appendChild(tbody);
    calendario.appendChild(tabella);
    tabellaVisibile = true;
}

function nascondiTabella() {
    tabella.innerHTML = '';
    tabellaVisibile = false;
}

calendario.addEventListener('click', () => {
    if (tabellaVisibile) {
        nascondiTabella();
    } else {
        mostraTabella();
    }
});
