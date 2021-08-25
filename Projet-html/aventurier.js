let mesProduits = JSON.parse(localStorage.getItem("produits"));

if (mesProduits != null) {
    for (let p of mesProduits) {
        creerLigne(p);
    }
}

function ajouterAventurier() {
    let nomAventurier = document.querySelector("[name = 'nom']").value;
    let experienceAventurier = document.querySelector("[name = 'experience']").value;
    let etatAventurier = document.querySelector("[name = 'etatAventurier']").value;

    let aventurier = {
        nom: nomAventurier,
        experience: experienceAventurier,
        etatAventurier: etatAventurier
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
    <td>${aventurier.etatAventurier}</td>
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