var loginViewModel = null;

var LoginViewModel = function(){
	
    this.login = ko.observable('');
    this.password = ko.observable('');
    this.hasError = ko.observable(false);
    this.fieldError = ko.observableArray([]);
    
    this.init = function(){
    	ko.applyBindings(document.getElementById("main"));	
    };
    
    
    this.validateLogin = function(){
    	var message = '';
    	loginViewModel.hasError(false);
    	
    	if(!loginViewModel.login() || loginViewModel.login() == ''){
    		loginViewModel.hasError(true);
    		message = 'Login cannot be empty.';
    	}

    	if(!loginViewModel.password() || loginViewModel.password() ==''){
    		loginViewModel.hasError(true);
    		if(message != ''){
    			message = 'Login and password cannot be empty.'
    		} else {
    			message = 'Password cannot be empty.'
    		}
    	}
    	
    	if(loginViewModel.hasError()){
    		Message.error(message);
    		return false;
    	} else {
    		Message.close();
    		return true;
    	}
    };
}

$(function() {
	loginViewModel = new LoginViewModel();
	loginViewModel.init();
	
});