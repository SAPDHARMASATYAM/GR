//function registration() {

//console.log("Registration called");
//try {
//var user = new Object();
//user.userName = $('#emailId').val();
//user.firstName = $('#firstName').val();
//user.lastName = $('#lastName').val();
//user.password = $('#password').val();

//$.ajax({
//url : "./user/register",
//type : 'POST',
//dataType : 'json',
//data : JSON.stringify(user),
//contentType : 'application/json',
//mimeType : 'application/json',

//success : function(data) {
//var respJSONString = JSON.stringify(data);
//console.log(respJSONString);

//},

//error : function(data, status, er) {
//alert("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
//window.location="./index.html"
//}
//});
//} catch (ex) {
//alert(ex);
//window.location="./index.html";
//}
//}

function login() {

	console.log("Login called");
	try {
		var user = new Object();
		user.userName = $('#userName').val();
		user.password = $('#pwd').val();

		console.log($('#userName').val() + " : " + $('#pwd').val() +" : " + JSON.stringify(user));
		if(user.userName == "admin@mail.com" && user.password == "admin" ){
			console.log("Login type is admin");
			window.location="./admin/adminHome.html";
		}else{
			$.ajax({
				url : "./user/login",
				type : 'POST',
				dataType : 'json',
				data : JSON.stringify(user),
				contentType : 'application/json',
				mimeType : 'application/json',

				success : function(data) {
					var respJSONString = JSON.stringify(data);
					console.log(respJSONString);

					var jsonObj = JSON.parse(respJSONString);
					console.log(jsonObj.responseStatus + " : " + jsonObj.responseMessage);
					alert(jsonObj.responseMessage);

					if(jsonObj.responseStatus == "success"){
						// Check browser support for session storage
						if (typeof(Storage) !== "undefined") {
							// Store
							var responseObject =JSON.parse(JSON.stringify(data.responseContent));
							sessionStorage.setItem("emailId", responseObject.userName);
							console.log("userName stored in session storage. " + sessionStorage.getItem("userName"));
						} else {
							console.log("Sorry, your browser does not support Web Storage...");
						}
						window.location="./Course_Display.html"
					}else{

					}

				},

				error : function(data, status, er) {
					alert("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
					window.location="./index.html";
				}
			});
		}
	} catch (ex) {
		alert(ex);
		window.location="./index.html";
	}
}