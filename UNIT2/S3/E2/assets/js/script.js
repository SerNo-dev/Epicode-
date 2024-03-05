const input = document.getElementById('nome');
const btnSave = document.getElementById('saveName');
const btnDelete = document.getElementById('remove');
const contenitore = document.getElementById('container');
const p = document.createElement('p');

btnSave.addEventListener('click',(e) =>{  
    e.preventDefault()
    localStorage.setItem('Nome',input.value);
    if(localStorage.getItem('Nome') !== null) {
     p.innerText =  input.value;
    contenitore.appendChild(p);
}})

btnDelete.addEventListener('click',(e)=>{
    e.preventDefault;
    p.remove();
    localStorage.removeItem('Nome');
})