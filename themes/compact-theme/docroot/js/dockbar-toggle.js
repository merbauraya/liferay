var dockbarToggle = $("<div />").css({
        position: "fixed",
        top: "0px",
        right: "0",
        background: "rgba(0, 0, 0, 0.5)",
        "border-radius": "5px 0px 0px 5px",
        padding: "5px",
        "font-size": "20px",
        "z-index": "9999",
        cursor: "pointer",
        color: "#ddd"
    }).html("<i class='fa fa-cogs'></i>").addClass("no-print");
    
    
    dockbarToggle.click(function() {
    	var dockbar = $(".dockbar");
    	if (dockbar)
    	{
    		if (dockbar.hasClass("hide")){
    			
    			dockbar.removeClass("hide");
  
    		}else
			{
    			dockbar.addClass("hide");

    			
			}
    	}
    	
    });
    
    //$("body").append(dockbarToggle);
    $("body").append(dockbarToggle);