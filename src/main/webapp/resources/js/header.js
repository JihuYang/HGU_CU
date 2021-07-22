function detectMediaSize() { 
    if ( window.matchMedia('(min-width: 0px) and (max-width: 992px)').matches ) {
         console.log('Mobile');
    } else {
         console.log('PC');
    }
};

// Register
window.addEventListener('resize', detectMediaSize, false);

// Initialization
detectMediaSize();


$(document).ready(function () 
{
    $('#dropdown-display').hover(function(){
		$('#dropdown-content').slideDown();
    }, function() {
        $('#dropdown-content').slideUp();
    });
    $('#dropdown-display-community').hover(function(){
		$('#dropdown-content-community').slideDown();
    }, function() {
        $('#dropdown-content-community').slideUp();
    });    
});

