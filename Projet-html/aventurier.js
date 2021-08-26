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

let mesAventuriersRecrutement = JSON.parse(localStorage.getItem("aventuriersRecrutement"));
let mesAventuriersGuilde = JSON.parse(localStorage.getItem("aventuriersGuilde"));

if (mesAventuriersRecrutement != null) {
    for (let a of mesAventuriersRecrutement) {
        creerLigneRecrutement(a);
    }
}

if (mesAventuriersGuilde != null) {
    for (let a of mesAventuriersGuilde) {
        creerLigneGuilde(a);
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

    creerLigneRecrutement(aventurier);
    sauvegarderRecrutement(aventurier);
}

function ajouterAventurierGuilde(aventurier) {
    aventurier.etat = etatsAventurier.find(e => e.id == 1).nom

    creerLigneGuilde(aventurier);
    sauvegarderGuilde(aventurier);
}

function sauvegarderRecrutement(aventurier) {
    let aventuriersRecrutement = JSON.parse(localStorage.getItem("aventuriersRecrutement"));

    if (aventuriersRecrutement == null) {
        aventuriersRecrutement = [];
    }

    aventuriersRecrutement.push(aventurier);

    localStorage.setItem("aventuriersRecrutement", JSON.stringify(aventuriersRecrutement));
}

function sauvegarderGuilde(aventurier) {
    let aventuriersGuilde = JSON.parse(localStorage.getItem("aventuriersGuilde"));

    if (aventuriersGuilde == null) {
        aventuriersGuilde = [];
    }

    aventuriersGuilde.push(aventurier);

    localStorage.setItem("aventuriersGuilde", JSON.stringify(aventuriersGuilde));
}

function creerLigneRecrutement(aventurier) {
    let ligneTableau = document.createElement("tr");
    ligneTableau.innerHTML = `
    <td>${aventurier.nom}</td>
    <td>${aventurier.experience}</td>
    <td>${aventurier.prix}</td>
    <td><button id='btn-recruter'>Recruter</button></td>
    `;

    document.querySelector("#recrutement tbody").append(ligneTableau);
}

function creerLigneGuilde(aventurier) {
    let ligneTableau = document.createElement("tr");
    ligneTableau.innerHTML = `
    <td>${aventurier.nom}</td>
    <td>${aventurier.experience}</td>
    <td>${aventurier.etat}</td>
    `;

    document.querySelector("#guilde tbody").append(ligneTableau);
}

document.querySelector("#btn-supprimer").addEventListener("click", () => {
    document.querySelector("#recrutement tbody").innerHTML = "";
    localStorage.setItem("aventuriersRecrutement", null);
})

document.querySelector("#btn-recruter").addEventListener("click", () => {
    localStorage.setItem("aventuriersRecrutement", null);
})

document.querySelector('input[name="nom"]').addEventListener('keyup', () => {
    document.querySelector('#new-aventurier').textContent = document.querySelector('input[name="nom"]').value;
});