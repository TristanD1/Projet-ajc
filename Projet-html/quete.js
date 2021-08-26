var listBtnAjouter = document.querySelectorAll("#ajout");
var listStatut = document.querySelectorAll(`#statut`);
var listEquipement = document.querySelectorAll('#eq');
var listBtnChoix = document.querySelectorAll('#btn-choix');
var listDropMenu = document.querySelectorAll('#dropdownMenu');
var listBtnDetails = document.querySelectorAll('#btn-details');

for (let btn of listBtnAjouter) {
    btn.addEventListener('click', () => {

        if (btn.textContent == 'Enlever') {
            btn.closest('tr').querySelector(`#statut`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            btn.textContent = 'Ajouter';
        }

        else {
            btn.closest('tr').querySelector(`#statut`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
            btn.textContent = 'Enlever'
        }
    })
};


document.querySelector(`#close`).addEventListener('click', () => {
    for (let statut of listStatut) {
        statut.innerHTML = '<i class="bi bi-person-x-fill"></i>';
    }
    for (let btnAjout of listBtnAjouter) {
        btnAjout.textContent = 'Ajouter';
    }
    for (let equipement of listEquipement) {
        equipement.closest('div').querySelector('#dropdownMenu').textContent = 'Choisir un équipement'
        }
});


for (let btnChoix of listBtnChoix) {
    btnChoix.addEventListener('click', () => {
        document.querySelector(`#intituleQueteChoisir`).textContent = btnChoix.closest('tr').querySelector('#intitule').textContent;
    })
};

for (let btnDetails of listBtnDetails) {
    btnDetails.addEventListener('click', () =>{
        document.querySelector(`#intituleQueteDetails`).textContent = btnDetails.closest('tr').querySelector('#intitule').textContent;
    })
    
}

for (let equipement of listEquipement) {
    equipement.addEventListener('click', () => {
        equipement.closest('div').querySelector('#dropdownMenu').textContent = equipement.textContent;

    })
};
