const BaseUrl = 'https://api.pexels.com/v1/search?query=';
const btnLoadImages = document.getElementById('loadImages');
const btnSecondaryImages = document.getElementById('secondaryImages');
const bottoniEditTohide = document.querySelectorAll('div > button:nth-child(2)');
window.addEventListener('load',init);
const cardBody = document.getElementsByClassName('card-body');
let array;
function init(){
    editTohide()
}

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
        deleteItem(index);
    });
});

