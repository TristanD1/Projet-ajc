$(document).ready(function(){
    $('#forEquip a').each(function() {
    	$(this).tooltip({
            title: "<h3>" + $(this).data('nom') + "</h3> <p> " + $(this).data('bonus') + " </p> <p> <i>" + $(this).data('descr') + "</i> </p>",
             html: true,
              placement: "bottom"
        }); 
    })
  });