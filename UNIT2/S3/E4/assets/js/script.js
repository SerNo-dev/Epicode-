const BaseUrl = 'https://api.pexels.com/v1/search?query=';
const btnLoadImages = document.getElementById('loadImages');
const btnSecondaryImages = document.getElementById('secondaryImages');
const bottoniEditTohide = document.querySelectorAll('div > button:nth-child(2)');
window.addEventListener('load',init);
const cardBody = document.getElementsByClassName('card-body');
const parola = document.getElementById('parola');
const ricerca = document.getElementById('search')
let array;
function init(){
    editTohide();
}
ricerca.addEventListener('click',()=>{
  search()
})

btnLoadImages.addEventListener('click', () => {
    loadImages(); 
})
btnSecondaryImages.addEventListener('click', () => {
    loadSecondaryImages(); 
});


const loadImages = async () => {
    try {
        let mountainsResponse = await fetch(BaseUrl + 'mountains', {
            headers: {
                Authorization: 'TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5'
            } 
        });
        let mountainsData = await mountainsResponse.json();
        displayImages(mountainsData.photos);
        array = mountainsData;
        console.log(array)
    } catch(error) {
        console.log(error);
    }
}

const displayImages = (photos) => {
    let immagini = document.querySelectorAll('img');
    immagini.forEach((img, index) => {
        if (photos[index]) {
            img.src = photos[index].src.large;
        }
    });
}

const loadSecondaryImages = async() =>{
    try{ let sunsetResponse = await fetch(BaseUrl + 'sunset',{
         headers: {
             Authorization: 'TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5'
         }
     });
     let sunsetData = await sunsetResponse.json();
     secondaryImages(sunsetData.photos);
     }catch(error){
         console.log(error);
     }
 }
 const secondaryImages = (photos) =>{
     let immagini = document.querySelectorAll('img');
     immagini.forEach((img,index)=>{
         if(photos[index]){
             img.src = photos[index].src.large
         }
     })
 }
 
  const editTohide = () =>{
    bottoniEditTohide.forEach(element =>{
        element.innerHTML = 'Hide'
    })
  }

  
  bottoniEditTohide.forEach((button, index) => {
    button.addEventListener('click', () => {
        const card = button.closest('.card');
        if (card) {
            card.style.display = 'none';
            
        }
    });
});

const search = async () => {
    if (parola.value.trim() !== '') {
        try {
            let mountainsResponse = await fetch(BaseUrl + parola.value, {
                headers: {
                    Authorization: 'TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5'
                } 
            });
            let foto = await mountainsResponse.json();
            searchImages(foto.photos);
            array = foto;
            console.log(foto);
        } catch(error) {
            console.log(error);
        }
    } else {
        console.log('Il campo di ricerca è vuoto');
    }
}

const searchImages = (photos) => {
    let immagini = document.querySelectorAll('img');
    immagini.forEach((img, index) => {
        if (photos[index]) {
            img.src = photos[index].src.large;
        }
    });
}
