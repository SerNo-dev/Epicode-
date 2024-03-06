let contenitoreCarte = document.getElementById('carte');
let arrayCarte = [];
let carrello = document.getElementById('carrello');


const readData = async () => {
    const risposta = await fetch('https://striveschool-api.herokuapp.com/books')
        .then(risposta => {
            return risposta.json();
        }).then(dati => {
            arrayCarte = dati;
            console.log(arrayCarte);
            stampa(arrayCarte)

        }).catch(err => {
            console.log('Errore nel recupero dei libri:', err)
        })

}
readData();
const stampa = (arrayCarte) => {
    contenitoreCarte.innerHTML = '';
    for (let i = 0; i < arrayCarte.length; i++) {
        const carta = document.createElement('div');
        carta.classList.add('card');
        carta.setAttribute('style', 'width: 18rem');
        const immagine = document.createElement('img');
        immagine.classList.add('card-img-top');
        immagine.setAttribute('src', arrayCarte[i].img);
        const bodycarta = document.createElement('div');
        bodycarta.classList.add('card-body');
        const titoloCarta = document.createElement('h5');
        titoloCarta.classList.add('card-title');
        titoloCarta.innerText = arrayCarte[i].title;
        const prezzoCarta = document.createElement('p');
        prezzoCarta.classList.add('card-text');
        prezzoCarta.innerText = arrayCarte[i].price;
        const categoria = document.createElement('p');
        categoria.classList.add('card-text');

        const bottone1 = document.createElement('button');
        bottone1.innerText = `Aggiungi`;
        bottone1.addEventListener('click', () => {
            aggiungi(arrayCarte[i]); 
        });

        const bottone2 = document.createElement('button');
        bottone2.innerText = `Elimina`;
        bottone2.addEventListener('click', () => {
            elimina(arrayCarte[i]);
        });

        bodycarta.append(titoloCarta, prezzoCarta, categoria, bottone1, bottone2);
        carta.appendChild(immagine);
        carta.appendChild(bodycarta);

        contenitoreCarte.appendChild(carta);
    }
}

const arrayChart = [];

const aggiungi = (libro) => {
    arrayChart.push(libro);
    popolacarrello(libro);
}

const popolacarrello = (arrChart) => {
    carrello.innerHTML = ''; 
    for (let i = 0; i < arrChart.length; i++) {
        const carta = document.createElement('div');
        carta.classList.add('card');
        carta.setAttribute('style', 'width: 18rem');
        const immagine = document.createElement('img');
        immagine.classList.add('card-img-top');
        immagine.setAttribute('src', arrChart[i].img);
        const bodycarta = document.createElement('div');
        bodycarta.classList.add('card-body');
        const titoloCarta = document.createElement('h5');
        titoloCarta.classList.add('card-title');
        titoloCarta.innerText = arrChart[i].title;

        carta.appendChild(immagine);
        bodycarta.appendChild(titoloCarta);
        carta.appendChild(bodycarta);
         console.log(arrChart[i])
        carrello.appendChild(carta);
    }
}

const elimina = (libro) => {
    const indice = arrayCarte.indexOf(libro);
        arrayCarte.splice(indice, 1);
        const elementoDaRimuovere = contenitoreCarte.children[indice];
            contenitoreCarte.removeChild(elementoDaRimuovere);
         stampa(arrayCarte);
}
