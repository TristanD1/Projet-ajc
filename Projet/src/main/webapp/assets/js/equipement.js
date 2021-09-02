$(document).ready(function(){
    $('#tooltip').tooltip({
        title: "<h3>${equipement.recomprense.nom}</h3> <img ${equipement.recompense.image}> <p> <i> ${equipement.recompense.description} </i> </p>",
         html: true,
          placement: "right"
    }); 
  });

