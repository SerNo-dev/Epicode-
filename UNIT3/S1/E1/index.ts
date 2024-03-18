interface Telefono {
    credito : number;
    numeroChiamate: number;
}


class User implements Telefono{
    credito: number;
    numeroChiamate: number;
    nome : string;
    cognome: string
    constructor (_credito: number,_numeroChiamate: number,_nome:string,_cognome : string){
    this.credito = _credito
    this.numeroChiamate = _numeroChiamate;
    this.nome = _nome;
    this.cognome = _cognome;
    }

    ricarica(x:number) {
     return x + this.credito
    }
    chiamata(minuti: number):void{
    const millisecondiInUnMinuto = 60000;
    const costoChiamataPerMinuto = 0.20
      if(minuti * millisecondiInUnMinuto > 0){
        const costoTotale = costoChiamataPerMinuto * minuti;
        this.credito -= costoTotale
        console.log(`Credito dopo la chiamata: ${this.credito}`);
      }
    }
    chiama404 () {
        return `Il tuo credito è ${this.credito}`
    }
    getNumeroChiamta() {
        return `Minuti passi in chiamata ${this.numeroChiamate}`
    }

}



const Call = new User(20, 0, 'Pippo', 'Biachi');
console.log(Call);
console.log(Call.ricarica(5));
console.log(Call.chiamata(0))
console.log(Call.chiama404());
console.log(Call.getNumeroChiamta());


const credito = document.getElementById('credito') as HTMLBodyElement;

credito.innerText = `Il tuo credito è ${Call.credito} euro`;

const minuti = document.getElementById('minuti') as HTMLBodyElement;

minuti.innerText = `${Call.getNumeroChiamta()}`;

const ricaricaInput = document.getElementById('inputRicarica') as HTMLInputElement;

const btnRicarica = document.getElementById('btnRicarica') as HTMLBodyElement;

btnRicarica.addEventListener('click', () =>{
    let ammontareRicarica = parseInt(ricaricaInput.value);
    credito.innerText = `Il tuo credito è ${Call.ricarica(ammontareRicarica)} euro`;

})

const btnChiama = document.getElementById('btnchiama') as HTMLBodyElement


let contatore = 0;
let intervallo;

btnChiama.addEventListener('click', ()=>{
  intervallo = setInterval(()=>{
    contatore++;
    console.log(contatore);
    Call.chiamata(contatore);
  },60000);
Call.chiamata(contatore);
} )










