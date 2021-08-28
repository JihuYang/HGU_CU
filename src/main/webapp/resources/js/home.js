function searchHome(){	
	document.getElementById("button-addon2").onclick = function () {
    
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/*console.log(searchType)
  			console.log(keyword)*/
  			
  			location.href = "/search?num=1"+ "&searchType=title" +"&keyword=" + keyword;
  			
 		};
}

function searchInSearchPage(){
	document.getElementById("searchBtn").onclick = function () {
    
    		let searchType = document.getElementsByName("searchType")[0].value;
  			let keyword =  document.getElementsByName("keyword")[0].value;
  
  			/*console.log(searchType)
  			console.log(keyword)*/
  			
  			location.href = "/search?num=1"+ "&searchType=" + searchType +"&keyword=" + keyword;
  			
 		};
}

function getContent(tag,searchType,keyword){
	//alert(keyword);
	if(typeof keyword == "undefined"){
		keyword = "";
	}
	location.href = "/search?num=1&searchType=" + searchType +"&keyword=" + keyword + "&tag=" + tag;

}