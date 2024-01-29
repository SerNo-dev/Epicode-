/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* Un data type in Javascript si riferisce al tipo di valore(come un giocattolo dentro una scatola) che una variabile può contenere.
 I principali tipi sono :
 1.Numero : let numero = 5; questo rapprensenta un numero che diamo alla nostra variabile numero
 2.Stringa :  let parola = 'ciao' ; questa variabile contiene invece una stringa cioè una parola o frase fatta di lettere
 3. Boolean :  con valori true o false,in base alla variabile che prendiamo che può essere vera o falsa,ad esempio let maggiorenne = false
 4.Null : assenza di un valore intenzionale,cioè diamo il valore null alla nostra variabile in modo tale che non abbia valore e per questo sarà anche false
 5.Undefined: questa è una variabile dichiarata ma a cui non è stato assegnato un valore  */

/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

 let myName = 'Sergio';
 console.log(myName);

/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

console.log(12 + 20);
function somma () {
     return 12+20
}
console.log(somma())


/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

let x = 12;

/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

myName = 'Nolasco';
console.log(myName);

/* const numero = 12 ;
numero = 20;
console.log(numero); /* in console mi darà errore,cioè che non posso riassegnare un altro valore */

/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

let sottrazione = 4-x;
console.log(sottrazione);

/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

let name1 = "john";
let name2 = "John";
console.log('name1 e name2 sono uguali:', name1 === name2);

console.log('In lowercase saranno uguali:', name1.toLowerCase() === name2.toLowerCase());
let uguali = 'Sono uguali';
let diversi = 'Sono diversi';

if(name1 === name2) {
  console.log(uguali)
} else {
   console.log(diversi)
};


if(name1.toLowerCase() === name2.toLowerCase()) {
    console.log('true')
} else {
  console.log('false')
}