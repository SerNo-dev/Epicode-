let task = document.getElementById('testo');
let button = document.getElementById('crea');
let lista = document.getElementById('lista');

button.addEventListener('click', (e) => {
    e.preventDefault();
    if (task.value.trim() !== '') { 
        let testoInserito = task.value.trim();
        let li = document.createElement('li'); 
        li.innerText = testoInserito; 


        
        let span = document.createElement('span');
        span.className = 'material-symbols-outlined';
        span.innerText = 'delete_forever';
        span.style.cursor = 'pointer'; 
        
      
        span.addEventListener('click', () => {
            li.remove();
        });
        
        
        li.appendChild(span);

       
        li.addEventListener('click' ,() => {
            li.style.textDecoration = "line-through";
        });

        lista.appendChild(li); 
        task.value = '';
    }
});
