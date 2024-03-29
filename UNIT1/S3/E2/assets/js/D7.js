/* ESERCIZIO 1
  Scrivi una funzione per concatenare due stringhe ricevute come parametri, selezionando solamente i primi 2 caratteri della
  prima e gli ultimi 3 della seconda. Converti la stringa risultante in maiuscolo e mostrala con un console.log().
*/
function concatena(stringa1, stringa2) {
  let primaStringa = stringa1.slice(0, 2).toUpperCase()
  let secondaStringa = stringa2.slice(-3).toUpperCase()
  return primaStringa.concat(secondaStringa)
}
console.log(concatena('Come', 'stai'));
/* ESERCIZIO 2 (for)
  Scrivi una funzione che torni un array di 10 elementi; ognuno di essi deve essere un valore random compreso tra 0 e 100 (incluso).
*/
function random() {
  let array = []

  for (i = 0; i < 10; i++) {
    array.push(Math.floor(Math.random() * 101))

  }
  return array

}
console.log(random())
/* ESERCIZIO 3 (filter)
  Scrivi una funzione per ricavare solamente i valori PARI da un array composto da soli valori numerici
*/

const elementi = [1, 5, 4, 8, 10, 20, 12, 24, 40];
 const ricava = elementi.filter((element, index) => {
  if (element % 2 === 0) {
  }
  return element % 2 === 0
})

console.log(ricava)
/* ESERCIZIO 4 (forEach)
  Scrivi una funzione per sommare i numeri contenuti in un array
*/
function calcolaSomma(array) {
  let somma = 0;
  array.forEach((element) => { // foreach si limita a fare ma non restituisce nulla
    somma += element;
  });
  return somma;
}

let arrayNumeriSomma = [2, 5, 6, 50, 8, 9];
let risultatoSomma = calcolaSomma(arrayNumeriSomma);
console.log(risultatoSomma); 

/* ESERCIZIO 5 (reduce)
  Scrivi una funzione per sommare i numeri contenuti in un array
*/
function calcola (){
    let numeri =[1,2,3,4,5,6,7,8,9,20];
      const totale = numeri.reduce((acc,ele,index) =>{
      return  acc+ ele
      })
      return totale
}
console.log(calcola())
///
let valoriSomma = [1.2, 3, 4, 5, 56];
const totaleValori = valoriSomma.reduce((val1, val2) => val1 + val2, 0);
console.log(totaleValori);

///
/* ESERCIZIO 6 (map)
  Scrivi una funzione che, dato un array di soli numeri e un numero n come parametri, ritorni un secondo array con tutti i valori del precedente incrementati di n
*/

function incrementaArray(array, n) {
  const nuovoArray = array.map((element) => {
    return element + n;
  });
  
  return nuovoArray;
}
const arrayDiNumeri = [1, 2, 3, 4, 5];
const numeroDaIncrementare = 10;
const nuovoArrayIncrementato = incrementaArray(arrayDiNumeri, numeroDaIncrementare);
console.log(nuovoArrayIncrementato);



/* ESERCIZIO 7 (map)
  Scrivi una funzione che, dato un array di stringhe, ritorni un nuovo array contenente le lunghezze delle rispettive stringhe dell'array di partenza
  es.: ["EPICODE", "is", "great"] => [7, 2, 5]
*/
let arrayStringhe = ["EPICODE", "is", "great"] ;
const ciao = arrayStringhe.map((element,index)=>{
let singoleLettere = element.split('')
return singoleLettere.length;
 
})
console.log(ciao)
/* ESERCIZIO 8 (forEach o for)
  Scrivi una funzione per creare un array contenente tutti i valori DISPARI da 1 a 99.
*/
function dispari (){
  let array = [];
for ( i = 0; i < 100; i++){
  if(i % 2 !== 0){
   array.push(i)
  }
}
 return array
}
console.log(dispari())
/* Questo array di film verrà usato negli esercizi a seguire. Non modificarlo e scorri oltre per riprendere gli esercizi :) */
const movies = [
  {
    Title: 'The Lord of the Rings: The Fellowship of the Ring',
    Year: '2001',
    imdbID: 'tt0120737',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings: The Return of the King',
    Year: '2003',
    imdbID: 'tt0167260',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings: The Two Towers',
    Year: '2002',
    imdbID: 'tt0167261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of War',
    Year: '2005',
    imdbID: 'tt0399295',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'Lords of Dogtown',
    Year: '2005',
    imdbID: 'tt0355702',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings',
    Year: '1978',
    imdbID: 'tt0077869',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1990',
    imdbID: 'tt0100054',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg',
  },
  {
    Title: 'The Lords of Salem',
    Year: '2012',
    imdbID: 'tt1731697',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Greystoke: The Legend of Tarzan, Lord of the Apes',
    Year: '1984',
    imdbID: 'tt0087365',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1963',
    imdbID: 'tt0057261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg',
  },
  {
    Title: 'The Avengers',
    Year: '2012',
    imdbID: 'tt0848228',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Infinity War',
    Year: '2018',
    imdbID: 'tt4154756',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Age of Ultron',
    Year: '2015',
    imdbID: 'tt2395427',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Endgame',
    Year: '2019',
    imdbID: 'tt4154796',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
  },
]

/* ESERCIZIO 9 (forEach)
  Scrivi una funzione per trovare il film più vecchio nell'array fornito.
*/

let arrayanno = [];

movies.forEach((element, index) => {
    arrayanno.push(element.Year);
});

let basso = Math.min(...arrayanno);

console.log(basso);
//////////////////////////
function piuVecchio(){
  let anno = 2100;
  movies.forEach((element) =>
  {
    if(Number(element.Year) < anno){ // da stringa a numero
      anno = Number(element.Year);
    }
  });
  console.log(anno);
}
piuVecchio();

/* ESERCIZIO 10
  Scrivi una funzione per ottenere il numero di film contenuti nell'array fornito.
*/

/* ESERCIZIO 11 (map)
  Scrivi una funzione per creare un array con solamente i titoli dei film contenuti nell'array fornito.
*/

/* ESERCIZIO 12 (filter)
  Scrivi una funzione per ottenere dall'array fornito solamente i film usciti nel millennio corrente.
*/

/* ESERCIZIO 13 (reduce)
  Scrivi una funzione per calcolare la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array fornito.
*/

/* ESERCIZIO 14 (find)
  Scrivi una funzione per ottenere dall'array fornito uno specifico film (la funzione riceve un imdbID come parametro).
*/

////////////////
function cercaFilm (id){
 const film = movies.filter(element => {
  return element.imdbID === id;
 } );
 return film
}

console.log(cercaFilm('tt4154796'))

////////////////////////

function film(id){
  return movies.find(element =>
    element.imdbID === id  // il find non vuole le graffe
  )
}

console.log(film('tt2395427'))
console.log('**Esercizio 14 **')
////////
const elenco = document.getElementById('elenco');
 movies.forEach(element =>{ // foreach perchè qua non serve creare un array ma usare lo stesso
  let option = document.createElement('option');
  option.setAttribute('value', element.imdbID);
  option.innerText = element.Title;
  elenco.appendChild(option);
 })

 document.getElementById('scegli').addEventListener('click',function (){
  let imdbID = elenco.value ;// il value che parte dall'html,value dell'option
  const filmScelto = movies.find((element) => {
    return element.imdbID === imdbID;
  });
  console.log(filmScelto);
  document.getElementById('titolo').innerText = filmScelto.Title;
  document.getElementById('anno').innerText= `Anno di produzione : ${filmScelto.Year}`
  document.getElementById('locandina').innerHTML = `<img src ="${filmScelto.Poster}" alt="locandina ${filmScelto.Title}" />`
});
/* ESERCIZIO 15 (findIndex)
  Scrivi una funzione per ottenere dall'array fornito l'indice del primo film uscito nell'anno fornito come parametro.
*/

