let etatsAventurier = [
    { id: 1, nom: "EN PLEINE FORME" },
    { id: 2, nom: "BLESSE" },
];

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
    let nomAventurier = aventurier.nom;
    let experienceAventurier = aventurier.experience;

    let monAventurier = {
        nom: nomAventurier,
        experience: experienceAventurier,
        etat: etatsAventurier.find(e => e.id == 1).nom
    };

    creerLigneGuilde(monAventurier);
    sauvegarderGuilde(monAventurier);
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
    <td><button id="btn-supprimer">Supprimer</button></td>
    `;

    document.querySelector("#recrutement tbody").append(ligneTableau);

    ligneTableau.querySelector("#btn-recruter").addEventListener("click", () => {
        let aventuriersRecrutement = JSON.parse(localStorage.getItem("aventuriersRecrutement"));

        if (aventuriersRecrutement != null) {
            let index = aventuriersRecrutement.indexOf(aventurier);

            aventuriersRecrutement.splice(index, 1);
            localStorage.setItem("aventuriersRecrutement", JSON.stringify(aventuriersRecrutement));
        }

        ligneTableau.remove();

        ajouterAventurierGuilde(aventurier);
    })

    ligneTableau.querySelector("#btn-supprimer").addEventListener("click", () => {
        let aventuriersRecrutement = JSON.parse(localStorage.getItem("aventuriersRecrutement"));

        if (aventuriersRecrutement != null) {
            let index = aventuriersRecrutement.indexOf(aventurier);

            aventuriersRecrutement.splice(index, 1);
            localStorage.setItem("aventuriersRecrutement", JSON.stringify(aventuriersRecrutement));
        }

        ligneTableau.remove();
    })
}

function creerLigneGuilde(aventurier) {
    let ligneTableau = document.createElement("tr");
    ligneTableau.innerHTML = `
    <td>${aventurier.nom}</td>
    <td>${aventurier.experience}</td>
    <td>${aventurier.etat}</td>
    <td><button id="btn-renvoyer">Renvoyer</button></td>
    `;

    document.querySelector("#guilde tbody").append(ligneTableau);

    ligneTableau.querySelector("#btn-renvoyer").addEventListener("click", () => {
        let aventuriersGuilde = JSON.parse(localStorage.getItem("aventuriersGuilde"));

        if (aventuriersGuilde != null) {
            let index = aventuriersGuilde.indexOf(aventurier);

            aventuriersGuilde.splice(index, 1);
            localStorage.setItem("aventuriersGuilde", JSON.stringify(aventuriersGuilde));
        }

        ligneTableau.remove();
    })
}

document.querySelector('input[name="nom"]').addEventListener('keyup', () => {
    document.querySelector('#new-aventurier').textContent = document.querySelector('input[name="nom"]').value;
});