function create(){
	$.ajax({
		  method: "POST",
		  url: contextPath + "/user/create",
		  data : { login: "markus", 
			       email: "markusreichel@gmail.com",
			       firstName: "Markus",
			       lastName: "Reichel",
			       password: "blchprms" }
		});
}