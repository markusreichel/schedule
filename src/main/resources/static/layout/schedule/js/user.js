
var userViewModel = null;

var UserViewModel = function() {

	this.init = function() {
		ko.applyBindings(document.getElementById("main"));
	};

	this.findAll = function() {
		var result = {"data" : []};
		$.ajax({
			method : "POST",
			url : contextPath + "/user/list",
			data : {},
			async : false,
			success : function(data, success, response) {
				for(var i = 0; i < data.result.length; i++){
					result.data.push(new User(data.result[i]));
				}
			}
		});
		return result;
	};
	
	this.create = function() {
		$.ajax({
			method : "POST",
			url : contextPath + "/user/create",
			data : {
				login : "markus",
				email : "markusreichel@gmail.com",
				firstName : "Markus",
				lastName : "Reichel",
				password : "blchprms"
			}
		});
	};

};

$(function() {
	userViewModel = new UserViewModel();
	userViewModel.init();
});