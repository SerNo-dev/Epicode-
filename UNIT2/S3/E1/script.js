class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location;
    }

    confronto(x = this.age, y = 0) {
        if (x > y) {
            console.log('X é piu vecchio di Y')
        } else {
            console.log('Y é piu vecchio di X')
        }
    }

}
class Persona1 extends User {
    constructor(_eta, ...User) {
        super(...User);
        this.eta = _eta;
    }
    confronto(x = this.age, y = this.eta) {
        if (x > y) {
            console.log('X é piu vecchio di Y')
        } else {
            console.log('Y é piu vecchio di X')
        }
    }
}
const persona = new Persona1(20, 'Sergio', 'Nolasco', 30, 'Sicilia')
persona.confronto()



class Pet {
    constructor(_nomeAnimale, _proprietario, _specie, _razza) {
        this.nomeAnimale = _nomeAnimale;
        this.proprietario = _proprietario
        this.specie = _specie;
        this.razza = _razza;
    }

    stessoPadrone() {
        let arrayPadroni = array.map(animale => animale.proprietario); 
        let stessoProprietario = false;
    
        for (let i = 0; i < arrayPadroni.length; i++) {
            if (arrayPadroni.indexOf(arrayPadroni[i]) !== i) {
                stessoProprietario = true;
                break; 
            }
        }
    
        console.log(arrayPadroni);
        console.log(stessoProprietario);
    } 

}
let divPets = document.getElementById('pets');
let array = [];
const aggiungi = document.getElementById('aggiungi');



aggiungi.addEventListener('click', (e) => {
    e.preventDefault();
    let nomeAnimale = document.getElementById('nomeAnimale').value;
    let proprietario = document.getElementById('proprietario').value;
    let specie = document.getElementById('specie').value;
    let razza = document.getElementById('razza').value;
    let animale = new Pet(nomeAnimale, proprietario, specie, razza);
    array.push(animale);
    animale.stessoPadrone()
    stampa();
})
const stampa = () => {
    divPets.innerHTML = '';
    array.forEach((animale) => {
        let colonna1 = document.createElement('td');
        colonna1.innerText = `${animale.nomeAnimale}`;
        let colonna2 = document.createElement('td');
        colonna2.innerText = `${animale.proprietario}`;
        let colonna3 = document.createElement('td');
        colonna3.innerText = `${animale.specie}`;
        let colonna4 = document.createElement('td');
        colonna4.innerText = `${animale.razza}`;
        let riga = document.createElement('tr');
        riga.append(colonna1, colonna2, colonna3, colonna4);
        divPets.appendChild(riga);
    })

}

