   
    function moveProgressBar(id, cout) {
    	
        var getPercent = ($("#hi"+id).data('progress-percent') / cout);
        $("#hii"+id).html(Math.round(getPercent*100)+"%");
        var getProgressWrapWidth = $("#hi"+id).width();
        var progressTotal = getPercent * getProgressWrapWidth;
        var animationLength = 2500;
        // on page load, animate percentage bar to data percentage length
        // .stop() used to prevent animation queueing
        $('#hi'+id+' .progress-bar').stop().animate({
            left: progressTotal
        }, animationLength);
        
    }