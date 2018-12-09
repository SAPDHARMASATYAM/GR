/**
 * 
 */
function getAvailableCourses() {

	alert("getAvailableCourses() called");
	try {
		$.ajax({
			url : "./course/getAllActiveCourses",
			type : 'GET',
			dataType : 'json',
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