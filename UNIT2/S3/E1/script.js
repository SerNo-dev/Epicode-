class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location;
    }

    compareAge(anotherUser) {
        if (this.age < anotherUser.age) {
            console.log(`${anotherUser.firstName} è più grande di ${this.firstName}`)
        } else if (this.age > anotherUser.age) {
            console.log(`${this.firstName} è più grande di ${anotherUser.firstName}`)
        } else {
            console.log(`${this.firstName} e ${anotherUser.firstName} hanno la stessa età`)
        }
    }

}

const persona1 = new User('Aldo', 'Gni', 20, 'Sicilia')
const persona2 = new User('Marco', 'Nolasco', 10, 'Sicilia')
persona2.compareAge(persona1);






class Pet {
    constructor(_nomeAnimale, _proprietario, _specie, _razza) {
        this.nomeAnimale = _nomeAnimale;
        this.proprietario = _proprietario
        this.specie = _specie;
        this.razza = _razza;
    }

    stessoPadrone() {
        let arrayPadroni = array.map(animale => animale.proprietario);

        for (let i = 0; i < arrayPadroni.length; i++) {
            if (arrayPadroni.indexOf(arrayPadroni[i]) !== i) {
                for (let j = 0; j < array.length; j++)
                    console.log(`I cani di nome : ${array[j].nomeAnimale} hanno lo stesso proprietario : ${arrayPadroni[i]} `)
            }
        }

        console.log(arrayPadroni);
     
    }

}
let listaAnimali = document.getElementById('listaAnimali');
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
    listaAnimali.innerHTML = '';
    array.forEach((animale) => {
        let colonna1 = document.createElement('td');
        colonna1.innerText = `${animale.nomeAnimale}`;
        let colonna2 = document.createElement('td');
        colonna2.innerText = `${animale.proprietario}`;
        let colonna3 = document.createElement('td');
        colonna3.innerText = `${animale.specie}`
        let colonna4 = document.createElement('td');
        colonna4.innerText = `${animale.razza}`
        let riga = document.createElement('tr');
        riga.append(colonna1, colonna2, colonna3, colonna4);
        listaAnimali.appendChild(riga)
    })

}

