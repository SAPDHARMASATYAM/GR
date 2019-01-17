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
						$("#coursesList").append($("<li>").text(obj.courseName));
//						var tabSpan = $("<span/>", {
//						    html: obj.courseName
//						});
//						var messageCenterAnchor = $("<a/>", {
//						    href:"#",
//						    html: tabSpan
//						});
//						var newListItem = $("<li/>", {
//						    html: messageCenterAnchor,
//						    "id": obj.courseName
//						});    // NOTE: you have to put quotes around "id" for IE..
//
//						$("coursesList ul").append(newListItem);
					});
					
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