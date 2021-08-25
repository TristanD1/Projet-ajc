let etatsAventurier = [
    { id: 1, nom: "EN PLEINE FORME" },
    { id: 2, nom: "BLESSE" },
];

for (let e of etatsAventurier) {
    let option = document.createElement("option");
    option.setAttribute("value", e.id);
    option.textContent = e.nom;

    document.querySelector("select[name='etatAventurier']").append(option);
}

let mesAventuriers = JSON.parse(localStorage.getItem("aventuriers"));

if (mesAventuriers != null) {
    for (let a of mesAventuriers) {
        creerLigne(a);
    }
}

function ajouterAventurierRecrutement() {
    let nomAventurier = document.querySelector("[name = 'nom']").value;
    let experienceAventurier = document.querySelector("[name = 'experience']").value;
    let prixAventurier = document.querySelector("[name = 'prix']").value;

    let aventurier = {
        nom: nomAventurier,
        experience: experienceAventurier,
        prix: prixAventurier
    };

    creerLigne(aventurier, "recrutement");
    sauvegarder(aventurier, "recrutement");
}

function ajouterAventurierGuilde(aventurier) {
    aventurier.etat = etatsAventurier.find(e => e.id == 1).nom

    creerLigne(aventurier, "guilde");
    sauvegarder(aventurier, "guilde");
}

function sauvegarder(aventurier) {
    let aventuriers = JSON.parse(localStorage.getItem("aventuriers"));

    if (aventuriers == null) {
        aventuriers = [];
    }

    aventuriers.push(aventurier);

    localStorage.setItem("aventuriers", JSON.stringify(aventuriers));
}

function creerLigne(aventurier, id) {
    let ligneTableau = document.createElement("tr");
    ligneTableau.innerHTML = `
    <td>${aventurier.nom}</td>
    <td>${aventurier.experience}</td>
    <td>${aventurier.prix}</td>
    <td><button id='btn-recruter'>Recruter</button></td>
    `;

    document.querySelector(`#${id} tbody`).append(ligneTableau);
}

document.querySelector("#btn-supprimer").addEventListener("click", () => {
    document.querySelector("table tbody").innerHTML = "";
    localStorage.setItem("aventuriers", null);
})

document.querySelector("#btn-recruter").addEventListener("click", () => {
    document.querySelector("#recrutement tbody tr").innerHTML = "";
})

document.querySelector('input[name="nom"]').addEventListener('keyup', () => {
    document.querySelector('#new-aventurier').textContent = document.querySelector('input[name="nom"]').value;
});