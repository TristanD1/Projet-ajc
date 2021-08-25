// document.querySelector('#checkbox').addEventListener('click', () => {
//     document.querySelector('#ajout').innerHTML = '<input class="form-check-input" type="checkbox" id="checkbox" value="" aria-label="..." checked><i class="bi bi-person-check-fill"></i>';
// });

// document.querySelector('#checkbox').addEventListener('click', () => {
//     document.querySelector('#ajout').innerHTML = '<input class="form-check-input" type="checkbox" id="checkbox" value="" aria-label="..." ></input>'
// });

var clicks = 1;

function onClick() {
    clicks += 1;
    document.getElementById("clicks").innerHTML = clicks;
};

document.querySelector('#ajout').addEventListener('click', () => {
    if (clicks % 2 == 0) {
        document.querySelector('#ajout').innerHTML = '<a class="btn btn-danger" onclick="onClick()">Enlever</a><i class="bi bi-person-check-fill"></i>';
    }
    else {
        document.querySelector('#ajout').innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>'
    }
    
})




