for (let i = 1; i < 100; i++) {

    document.querySelector(`#ajout${i}`).addEventListener('click', () => {
       
        if (document.querySelector(`#ajout${i}`).innerHTML == `<a class="btn btn-danger" onclick="onClick()">Enlever</a>`) {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>';
        }
        else {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Enlever</a>';
        }

        // if (clicks % 2 == 0 & clicks!=0) {

        //     document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
        //     document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>';
        // }
        // else {

        //     document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-check-fill"></i>';
        //     document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Enlever</a>';
        // }


        document.querySelector(`#close`).addEventListener('click', () => {
            document.querySelector(`#statut${i}`).innerHTML = '<i class="bi bi-person-x-fill"></i>';
            document.querySelector(`#ajout${i}`).innerHTML = '<a class="btn btn-danger" onclick="onClick()">Ajouter</a>';
        });

    })
}






