var User = /** @class */ (function () {
    function User(_credito, _numeroChiamate, _nome, _cognome) {
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
        this.nome = _nome;
        this.cognome = _cognome;
    }
    User.prototype.ricarica = function (x) {
        return x + this.credito;
    };
    User.prototype.chiamata = function (minuti) {
        var costoChiamataPerMinuto = 0.20;
        var costoTotale = Math.ceil(minuti) * costoChiamataPerMinuto;
        var costoDaAddebitare = Math.min(costoTotale, costoChiamataPerMinuto);
        this.credito -= costoDaAddebitare;
        console.log("Credito dopo la chiamata: ".concat(this.credito));
    };
    User.prototype.chiama404 = function () {
        return "Il tuo credito \u00E8 ".concat(this.credito);
    };
    User.prototype.getNumeroChiamta = function () {
        return "Minuti passi in chiamata ".concat(this.numeroChiamate);
    };
    return User;
}());
var Call = new User(20, 0, 'Pippo', 'Biachi');
console.log(Call);
console.log(Call.ricarica(5));
console.log(Call.chiamata(0));
console.log(Call.chiama404());
console.log(Call.getNumeroChiamta());
var credito = document.getElementById('credito');
credito.innerText = "Il tuo credito \u00E8 ".concat(Call.credito, " euro");
var ricaricaInput = document.getElementById('inputRicarica');
var btnRicarica = document.getElementById('btnRicarica');
btnRicarica.addEventListener('click', function () {
    var ammontareRicarica = parseInt(ricaricaInput.value);
    credito.innerText = "Il tuo credito \u00E8 ".concat(Call.ricarica(ammontareRicarica), " euro");
});
var btnChiama = document.getElementById('btnchiama');
var contatore = 0;
var intervallo;
var minuti = document.getElementById('minuti');
btnChiama.addEventListener('click', function () {
    intervallo = setInterval(function () {
        contatore++;
        console.log(contatore);
        minuti.innerText = "Minuti passati in chiamata ".concat(contatore);
        Call.chiamata(contatore);
    }, 60000);
    Call.chiamata(contatore);
});
