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