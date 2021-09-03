

$(document).ready(function(){
    $('#infobulle button').each(function() {
    	$(this).tooltip({
            title: "<h3>" + $(this).data('nom') + "</h3> <img src='" + $(this).data('img') + "'> <p> <i>" + $(this).data('descr') + "</i> </p>",
             html: true,
              placement: "right"
        }); 
    })
  });