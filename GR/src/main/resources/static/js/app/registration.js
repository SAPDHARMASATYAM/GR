function registration() {

	alert("Registration called");
	try {
		var user = new Object();
		user.userName = $('#emailId').val();
		user.firstName = $('#firstName').val();
		user.lastName = $('#lastName').val();
		user.password = $('#password').val();

		$.ajax({
			url : "./user/register",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(user),
			contentType : 'application/json',
			mimeType : 'application/json',

			success : function(data) {
				var respJSONString = JSON.stringify(data);
				console.log(respJSONString);

			},

			error : function(data, status, er) {
				alert("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
				window.location="./index.html"
			}
		});
	} catch (ex) {
		alert(ex);
		window.location="./index.html"
	}
}