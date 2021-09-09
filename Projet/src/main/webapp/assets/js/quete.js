var listBtnAjouter = document.querySelectorAll("#ajout");
var listStatut = document.querySelectorAll(`#statut`);
var listEquipement = document.querySelectorAll('#eq');
var listBtnChoix = document.querySelectorAll('#btn-choix');
var listDropMenu = document.querySelectorAll('#dropdownMenu');
var listBtnDetails = document.querySelectorAll('#btn-details');

for (let btn of listBtnAjouter) {
    btn.addEventListener('click', () => {

    	 if (btn.textContent == 'Enlever') {
             btn.closest('tr').querySelector(`#statut`).innerHTML = '<i class="bi bi-person-x-fill" id="imageStatut"></i>';
             btn.textContent = 'Ajouter';
         }

         else {
             btn.closest('tr').querySelector(`#statut`).innerHTML = '<i class="bi bi-person-check-fill" id="imageStatut"></i>';
             btn.textContent = 'Enlever'
         }
    })
};


//document.querySelector(`#close`).addEventListener('click', () => {
//    for (let statut of listStatut) {
//        statut.innerHTML = '<i class="bi bi-person-x-fill" id="imageStatut"></i>';
//    }
    // for (let btnAjout of listBtnAjouter) {
    //     if(btnAjout.textContent == 'Ajouter'){
    //     btnAjout.textContent = 'Ajouter';
    //     }
    //     else{btnAjout.textContent = 'Enlever';}
    // }
//    for (let equipement of listEquipement) {
//        equipement.closest('div').querySelector('#dropdownMenu').textContent = 'Choisir un équipement'
//        }
//});

// for (let btnChoix of listBtnChoix) {
//     btnChoix.addEventListener('click', () => {
//         document.querySelector(`#intituleQueteChoisir`).textContent = btnChoix.closest('tr').querySelector('#intitule').textContent;
//     })
// };

// for (let btnDetails of listBtnDetails) {
//     btnDetails.addEventListener('click', () =>{
//         document.querySelector(`#intituleQueteDetails`).textContent = btnDetails.closest('tr').querySelector('#intitule').textContent;
//     })
    
// }

 for (let equipement of listEquipement) {
     equipement.addEventListener('click', () => {
        equipement.closest('div').querySelector('#dropdownMenu').textContent = equipement.textContent;

     })
 };

// document.querySelector('#btn-choix2').addEventListener('click', () =>{
//     document.querySelector('#intituleQueteChoisir').textContent = document.querySelector('#intituleQueteDetails').textContent;
// });



//ajouter l'vent sur le bouton
for (let btn of listBtnAjouter) {
    btn.addEventListener('click', function() {
        let aventurierId = this.getAttribute('data-aventurier');
        let queteId = this.getAttribute('data-quete');

        //Utiliser l'API fetch
        fetch(`http://localhost:8080/api/associer-quete-aventurier?idAventurier=${ aventurierId }&idQuete=${ queteId }`);

    })
}

for(let btnEq of listEquipement ){
    btnEq.addEventListener('click', function(){
        let aventurierId = this.getAttribute('data-aventurier');
        let equipementId = this.getAttribute('data-equipement');

        fetch(`http://localhost:8080/api/associer-equipement-aventurier?idEquipement=${equipementId}&idAventurier=${aventurierId}`);
    })
}



// fetch('URL', {
//     method: 'POST',

//     headers: {
//     'Content-Type': 'application/json'
//     },

// body: JSON.stringify({

// })
// });



// fetch('http://localhost:8080/api/test/ici?id=x&autre=3')
// .then(resp => resp.json()) //transforme en objet JS
// .then(obj => {
//     //traitement JS ici
// })
// ;