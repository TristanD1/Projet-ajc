let etatsAventurier = [
    { id: 1, nom: "EN PLEINE FORME" },
    { id: 2, nom: "BLESSE" },
];

for (let e of etatsAventurier) {
    document.querySelector("select[name='etatAventurier']").innerHTML += `<option value="${e.id}">${e.nom}</option>`;

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

function ajouterAventurier() {
    let nomAventurier = document.querySelector("[name = 'nom']").value;
    let experienceAventurier = document.querySelector("[name = 'experience']").value;
    let etatAventurier = document.querySelector("[name = 'etatAventurier']").value;
    let etatNom = "";

    let etatTrouve = etatsAventurier.find(e => e.id == etatAventurier);

    etatNom = etatTrouve.nom;

    let aventurier = {
        nom: nomAventurier,
        experience: experienceAventurier,
        etat: etatNom
    };

    creerLigne(aventurier);
    sauvegarder(aventurier);
}

function sauvegarder(aventurier) {
    let aventuriers = JSON.parse(localStorage.getItem("aventuriers"));

    if (aventuriers == null) {
        aventuriers = [];
    }

    aventuriers.push(aventurier);

    localStorage.setItem("aventuriers", JSON.stringify(aventuriers));
}

function creerLigne(aventurier) {
    let ligneTableau = document.createElement("tr");
    ligneTableau.innerHTML = `
    <td>${aventurier.nom}</td>
    <td>${aventurier.experience}</td>
    <td>${aventurier.etat}</td>
    `;

    document.querySelector("table tbody").append(ligneTableau);
}

document.querySelector("#btn-vider").addEventListener("click", () => {
    document.querySelector("table tbody").innerHTML = "";
    localStorage.setItem("aventuriers", null);
})

document.querySelector('input[name="nom"]').addEventListener('keyup', () => {
    document.querySelector('#new-aventurier').textContent = document.querySelector('input[name="nom"]').value;
});