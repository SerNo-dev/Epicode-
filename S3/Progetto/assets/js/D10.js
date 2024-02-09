/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

// JS Basics

/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.

*/
console.log('***ESERCIZIO_A***')
let sum = 10 + 20;
console.log(sum);

/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/
console.log('***ESERCIZIO_B***')
let random = Math.floor(Math.random() * 20);
console.log(random)

/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/
console.log('***ESERCIZIO_C***')
let me = {
  name: 'Sergio',
  surname: 'Nolasco',
  age: '28'
}
console.log(me)
/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/
console.log('***ESERCIZIO_D***')
delete (me.age);
console.log(me)
/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/

console.log('***ESERCIZIO_E***')
me.skills = ['HTML', 'CSS'];

console.log(me);


/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/
console.log('***ESERCIZIO_F***')
me.skills.push('jAVASCRIPT');
console.log(me)

/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/
console.log('***ESERCIZIO_G***')
me.skills.pop();
console.log(me)

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/
console.log('***ESERCIZIO_1***')
function dice() {
  let random = Math.floor(Math.random() * 6) + 1;
  return random

}
dice()

/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/
console.log('***ESERCIZIO_2***')
function whoIsBigger(numero1, numero2) {
  let maggiore = Math.max(numero1, numero2);
  console.log(maggiore);
}
whoIsBigger(10, 20);
/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.
   Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/
console.log('***ESERCIZIO_3***')
function splitMe(stringa) {
  let array = stringa.split(' ');
  return array
}
console.log(splitMe('I love coding'))

/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/
console.log('***ESERCIZIO_4***')
function deleteOne(stringa, booleano) {
  if (booleano) {
    return stringa.slice(1);
  } else {
    return stringa.slice(0, -1);
  }

}
console.log(deleteOne('Ciao bello', true));
console.log(deleteOne('Ciao bello', false))
/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/
console.log('***ESERCIZIO_5***')
function onlyLetters(stringa) {
  let frase = '';
  for (i = 0; i < stringa.length; i++) {
    let carattere = stringa.charAt(i)
    if (isNaN(parseInt(carattere))) {
      frase += carattere;
    }
  }
  return frase
}
console.log(onlyLetters('I have 44 dogs 5555'))
/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/
console.log('***ESERCIZIO_6***')
function isThisAnEmail(stringa) {
  let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(stringa);
}

let email = "pippo@hotmail.it";
console.log(isThisAnEmail(email));

/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/
console.log('***ESERCIZIO_7***');

function whatDayIsIt() {
  const giorniDellaSettimana = [
    'Lunedi',
    'Martedi',
    'Mercoledi',
    'Giovedì',
    'Venerdì',
    'Sabato',
    'Domenica'
  ];

  let data = new Date();
  let giornoCorrente = data.getDay();

  for (let i = 0; i < giorniDellaSettimana.length; i++) {
    if (giornoCorrente === i + 1) {
      console.log("Oggi è " + giorniDellaSettimana[i]);
      break;
    }
  }
}

whatDayIsIt();

/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/

console.log('***ESERCIZIO_8***');



function rollTheDices(numeri) {
  let somma = 0;
  let valori = [];

  for (let i = 0; i < numeri; i++) {
    let random = dice();
    somma += random;
    valori.push(random);
  }

  let risultato = {
    sum: somma,
    values: valori
  };
  return risultato
}

let result = rollTheDices(4);
console.log(result)


/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/

console.log('***ESERCIZIO_9***');
function howManyDays(data) {
  let dataInMillisecondi = new Date(data).getTime();
  let oggiInMillisecondi = new Date().getTime();
  let differenzaInSecondi = (oggiInMillisecondi - dataInMillisecondi) / 1000;
  let secondiInUnGiorno = 24 * 60 * 60;

  let giorniTrascorsi = Math.floor(differenzaInSecondi / secondiInUnGiorno);
  return giorniTrascorsi;
}

let dataFornita = '2022-01-20';
let giorniTrascorsi = howManyDays(dataFornita);
console.log("Giorni trascorsi da", dataFornita, ":", giorniTrascorsi);

/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/


console.log('***ESERCIZIO_10***');

function isTodayMyBirthday() {
  let oggi = new Date();
  let mese = oggi.getMonth() + 1;
  let giorno = oggi.getDate();

  if (mese === 9 && giorno === 12) {
    return true;
  } else {
    return false;
  }
}

console.log(isTodayMyBirthday());

// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/


console.log('***ESERCIZIO_11***');
function deleteProp(oggetto, stringa) {

  if (stringa in oggetto) {
    delete oggetto[stringa]
    console.log(oggetto)
  }

}
let cane = { cane: 'boxer', colore: 'brown' };
let stringa = 'colore';
deleteProp(cane, stringa)






///////////////////

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


/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/
console.log('***ESERCIZIO_12***');
function newestMovie() {
  let anno = 1;
  movies.forEach((element) => {
    if (Number(element.Year) > anno) {
      anno = Number(element.Year);
    }
  })
  console.log(anno);

}
newestMovie()
/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/
console.log('***ESERCIZIO_13***');
function countMovies() {
  let numero = movies.length;
  console.log(numero)
}
countMovies()
/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/
console.log('***ESERCIZIO_14***');
function onlyTheYears() {
  let array = [];
  movies.forEach((element) => {
    array.push(element.Year);

  })
  console.log(array)
}
onlyTheYears()
/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/
console.log('***ESERCIZIO_15***');
function onlyInLastMillennium() {

  const film = movies.filter((data) => data.Year < 2000)
  console.log(film);
}
onlyInLastMillennium()
/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/
console.log('***ESERCIZIO_16***');
function sumAllTheYears() {

  const somma = movies.reduce((acc, film) => acc + parseInt(film.Year), 0);
  console.log(somma)
}
sumAllTheYears()
/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/
console.log('***ESERCIZIO_17***');
function searchByTitle(stringa) {
  movies.filter((element) => {
    if (element.Title.includes(stringa)) {
      console.log(element.Title);
    }
  })
}

searchByTitle('Avengers')
/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/
console.log('***ESERCIZIO_18***');
function searchAndDivide(stringa) {
  let match = [];
  let unmatch = []
  movies.filter((element) => {
    if (element.Title.includes(stringa)) {
      match.push(element.Title);
    } else {
      unmatch.push(element.Title)
    }
  });
  return {
    match: match,
    unmatch: unmatch
  };
}

console.log(searchAndDivide('Avengers'));

/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/
console.log('***ESERCIZIO_19***');

function removeIndex(numero) {
  movies.splice(numero, 1);
  return movies

}

console.log(removeIndex(4))



// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/
console.log('***ESERCIZIO_20***');
function contenitore() {
  let div = document.getElementById('container');
  return div
}
console.log(contenitore())
/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/
console.log('***ESERCIZIO_21***');

function cella() {
  let celle = document.querySelectorAll('td');
  return celle;
}

console.log(cella());
/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/
console.log('***ESERCIZIO_22***');
function stampa() {
  let celle = document.querySelectorAll('td');
  for (let i = 0; i < celle.length; i++) {
    let testo = celle[i].textContent;
    console.log(testo);
  }
}

stampa();
/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/
console.log('***ESERCIZIO_23***');
function background() {
  let links = document.querySelectorAll('a');

  links.forEach(link => {
    link.style.color = 'red';
  })
}
background();
/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/
function aggiungi (){
  let lista = document.querySelector('#myList');
  let li = document.createElement('li');

  lista.appendChild(li);

}
aggiungi()

/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/

/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/

// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/

/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/

/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/

/* Questo array viene usato per gli esercizi. Non modificarlo. */

