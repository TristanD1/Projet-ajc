var clicks = 1;

function onClick() {
    clicks += 1;
    document.getElementById("clicks").innerHTML = clicks;
};



for (let i = 1; i < 100; i++) {

    document.querySelector(`#ajout${i}`).addEventListener('click', () => {

        if (clicks % 2 == 0) {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
        }
        else {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>'
        }

    })
    document.querySelector(`#close`).addEventListener('click', () =>{
        clicks=1
    });

}




