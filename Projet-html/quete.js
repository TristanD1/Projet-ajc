var listBtnAjouter = document.querySelectorAll("#ajout");

for (let btn of listBtnAjouter) {
    btn.addEventListener('click', () => {

        if (btn.innerHTML == 'Enlever') {
            document.querySelector(`#statut`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            btn.innerHTML = 'Ajouter';
        }

        else {
            document.querySelector(`#statut`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
            btn.innerHTML = 'Enlever'
        }
        document.querySelector(`#close`).addEventListener('click', () => {
            document.querySelector(`#statut`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            btn.innerHTML = 'Ajouter';
        })
    })
};


// document.querySelector(`#btn-choix1`).addEventListener('click', () =>{
//     document.querySelector(`#intituleQuete`).textContent = document.querySelector(`#intitule1`).textContent;
// })

// document.querySelector('#eq1').addEventListener('click', () =>{
//     document.querySelector('#dropdownMenuButton1').textContent = document.querySelector('#eq1').textContent;

// })
