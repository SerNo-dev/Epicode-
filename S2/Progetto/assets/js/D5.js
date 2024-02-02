/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ['dog', 'cat', 'hamster', 'redfish']

for (i = 0; i < pets.length; i++) {
  console.log(pets[i])
}
console.log('***ESERCIZIO1***')
/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/
function ordinaArray(array) {
  let copia = array.slice()
  let ordina = copia.sort()
  return ordina;
}
let ordina = ordinaArray(pets);
console.log(ordina);
console.log('***ESERCIZIO2***')
/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/

function invertiArray(inverti) {
  let copia = inverti.slice();
  return copia.reverse();
}

let arrayInvertito = invertiArray(pets);

console.log(arrayInvertito);

console.log('***ESERCIZIO3***')

/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/
function sposta(array) {
  let copia = array.slice();
  let prendi = copia.shift();
  copia.push(prendi);
  return copia;
}
let spostato = sposta(pets);
console.log(spostato)
console.log('***ESERCIZIO4***')
/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
  },
]

for (i = 0; i < cars.length; i++) {
  cars[i].licensePlate = '45g257f'
}
console.log(cars)
console.log('***ESERCIZIO5***')
/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/
let nuovaAuto = { model: 'Pegeot', licensePlate: 'GHI789', trims: ['life', 'style', 'r-line'], };
cars.push(nuovaAuto);
console.log(cars);
for (i = 0; i < cars.length; i++) {
  cars[i].trims.pop()
}
console.log(cars)

console.log('***ESERCIZIO6***')
/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = []
for (i = 0; i < cars.length; i++) {
  let prendiamo = cars[i].trims.shift();
  justTrims.push(prendiamo)
}
console.log(justTrims)
console.log('***ESERCIZIO7***')
/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/
for (let i = 0; i < cars.length; i++) {
  let colore = cars[i].color;

  if (colore && colore.charAt(0).toLowerCase() === 'b') {
    console.log('Fizz');
  } else {
    console.log('Buzz');
  }
}
console.log('***ESERCIZIO8***')
/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
]
let n = 0;
while (n < numericArray.length) {
  console.log(numericArray[n]);

  if (numericArray[n] === 32) {
    break;
  }

  n++;
}
console.log('***ESERCIZIO9***')
/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
