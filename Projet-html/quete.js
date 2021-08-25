for (let i = 1; i <= 3; i++) {
//elementHTML.getAttribute('attr')
//elementHTML.setAttribute('attr', 'value')
    document.querySelector(`#ajout${i}`).addEventListener('click', () => {
       
        if (document.querySelector(`#ajout${i}`).innerHTML == `<a class="btn btn-danger" onclick="onClick()">Enlever</a>`) {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>';
        }
        else {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Enlever</a>';
        }
        document.querySelector(`#close`).addEventListener('click', () => {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>';
        });

    })
}


document.querySelector(`#btn-choix1`).addEventListener('click', () =>{
    document.querySelector(`#intituleQuete`).textContent = document.querySelector(`#intitule1`).textContent;
})

document.querySelector('#eq1').addEventListener('click', () =>{
    document.querySelector('#dropdownMenuButton1').textContent = document.querySelector('#eq1').textContent;

})
// function myfunction(){
// var x = document.getElementById("ajout").getAttribute("name");



// console.log(x);
// }
// myfunction();