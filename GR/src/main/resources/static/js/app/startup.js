/**
 * 
 */
function getAvailableCourses() {

	//alert("getAvailableCourses() called");
	try {
		$.ajax({
			url : "./course/getAllActiveCourses",
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			mimeType : 'application/json',

			success : function(data) {
				var respJSONString = JSON.stringify(data);
				//console.log(respJSONString);
				var jsonObj = JSON.parse(respJSONString);
				console.log(jsonObj.responseStatus + " : " + jsonObj.responseMessage);
				if(jsonObj.responseStatus == "success"){
					$.each(data.responseContent, function(idx, obj) {
						console.log("Content : " + obj.courseName);
					})
					
				}
				
			},

			error : function(data, status, er) {
				alert("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
				//window.location="./index.html"
			}
		});
	} catch (ex) {
		alert(ex);
		//window.location="./index.html"
	}
}