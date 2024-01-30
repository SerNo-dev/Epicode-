/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

let numero1 = 20;
let numero2 = 10;

if (numero1 > numero2) {
  console.log(numero1 + " è maggiore di " + numero2);
} else if (numero2 > numero1) {
  console.log(numero2 + " è maggiore di " + numero1);
} else {
  console.log("I numeri sono uguali");
}


/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/
let number = 8;
if (number !== 5) {
  console.log('not equal')

};


/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

let divCinque = 25;
let resto = 25 % 5;
if ( resto === 0) {
  console.log('divisibile per 5')
} else {
  console.log('Non divisibile per 5')
}

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/


let intero1 = 5;
let intero2 = 8;

if (intero1 === 8 || intero2 === 8 || intero1 + intero2 === 8) {
  console.log('Il valore di uno dei due è 8 o la loro somma è 8');
} else {
  console.log('Non c\'è un 8');
}



/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

let totalShoppingCart = 60;
let spedizione = 10;

if ( totalShoppingCart > 50) {
  console.log('Hai diritto alla spedizione gratuita')
} else {
  let ammontare = totalShoppingCart + 10;
   console.log('Il tuo ammontare è' + ammontare)
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

 totalShoppingCart = 40;
 spedizione = 10;
promozione =  totalShoppingCart + (totalShoppingCart * (20/100));

if ( totalShoppingCart > 50 || promozione >50) {
  console.log('Hai diritto alla spedizione gratuita')
} else {
  let ammontare = promozione + 10;
   console.log('Il tuo ammontare è' + ammontare )
}



/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/






/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/
let valore = "ciao";
if( typeof valore  === 'number' ) {
 console.log("Valore è un numero")
} else {
  console.log("Valore non è un numero")
}

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/
 
let numerino = 27;
let rest = numerino % 2;

if ( rest === 0) {
  console.log('Il numero è pari')
} else {
  console.log('Il numero è dispari')
}


 /*ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza. */
  
 
 
  let val = 7
  if (val < 5) {
      console.log("Meno di 5");
    } else if (val < 10) {
      console.log("Meno di 10");
    } else {
      console.log("Uguale a 10 o maggiore");
    }



/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
}

me.city = 'Toronto';
console.log(me)

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

delete me.lastName;
 console.log(me)

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

me.skills.pop();
console.log(me)

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

 let vuoto = [];
 for (let i = 1; i <= 10; i++) {
  vuoto.push(i);
}

console.log(vuoto);


/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

vuoto[9] = 100;

console.log(vuoto)
