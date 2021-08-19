function searchHome(){	
	document.getElementById("button-addon2").onclick = function () {
    
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/*console.log(searchType)
  			console.log(keyword)*/
  			
  			location.href = "/hgu/search?num=1"+"&keyword=" + keyword;
  			
 		};
}

function searchInSearchPage(){
	document.getElementById("searchBtn").onclick = function () {
    
    		let searchType = document.getElementsByName("searchType")[0].value;
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/*console.log(searchType)
  			console.log(keyword)*/
  			
  			location.href = "/hgu/search?num=1"+ "&searchType=" + searchType +"&keyword=" + keyword;
  			
 		};
}