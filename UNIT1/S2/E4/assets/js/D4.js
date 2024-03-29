/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/
function area(num1, num2) {
   let area = num1 * num2;
   return area;
 }
  console.log(area(11,12))


/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

 function crazySum (num1,num2){
   if( num1 ===  num2 ) {
       return (num1+num2) * 3;
   } else {
    return  num1+num2
   }

 }
 console.log(crazySum(5,5))

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

function crazyDiff (num1){
    if (num1 > 19 ) {
  return  (num1 - 19) * 3;
   } else {
  return 19 - num1
   }

}
console.log(crazyDiff(15))

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

function boundary(n){
   if (n > 20 && n<100 || n === 400) {
      return true
   } else {
      return false;
   }
}

console.log(boundary(400))
/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/
function epify (stringa) {
if ( stringa.startsWith('EPICODE')){
   return stringa;
} else {
  return 'EPICODE' + stringa; // Aggiungi EPICODE prima della stringa che ti è arrivata
}
}
console.log(epify('EPICODE FS0124'))

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/
function check3and7 (numero){
   if( (numero % 3 === 0) || (numero % 7 === 0) )
   {
    return 'è un multiplo di tre'
} 
return "Non è un multiplo di 3"
}
console.log(check3and7(9))
/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

function reverseString(str) {
 
   const charArray = str.split('');
   const reversedArray = charArray.reverse();
   const reversedString = reversedArray.join('');
   return reversedString;
} 
console.log(reverseString('Bella li'))

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

 function upperFirst(parola) {
   
     const chart = parola.charAt(0); // Prendiamo la prima lettera 
     const upper = chart.toUpperCase(); //Facciamo maiuscola la lettere presa sopra 
     const restop = parola.slice(1); // resto della stringa dalla seconda letta in poi
  return upper + restop
 }
 console.log(upperFirst('bella li amico'))

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/
 function cutString(stringa){
   const newStringa =  stringa.slice(1,-1);
   return newStringa
 }

 console.log(cutString('EPICODE'))
/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
