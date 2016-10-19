var showViewModel = null;

var ShowViewModel = function(){
	
    this.shows = ko.observableArray([]);
    
    this.init = function(){
    	ko.applyBindings(document.getElementById("main"));	
    };
    
    
    this.doLogin = function(){
/*    	$.ajax({
  		  method: "POST",
  		  url: contextPath + "/login",
  		  data : { 	login: loginViewModel.login(), 
  		  	        password: loginViewModel.password()
  			     }
  		});*/
    };
}

$(function() {
	showViewModel = new ShowViewModel();
	showViewModel.init();
	
});