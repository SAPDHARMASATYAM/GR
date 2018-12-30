function addCourse() {

	alert("addCourse called");
	try {
		var course = new Object();
		course.courseName = $('#courseName').val();
		course.isCourseActive = $('#isCourseActive').val();

		console.log();
		$.ajax({
			url : "../course/addCourse",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
				$('#addCourseDiv').hide();
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
function modifyCourse() {

	console.log("Login called");
	try {
		var course = new Object();
		course.userName = $('#userName').val();
		course.password = $('#pwd').val();

		console.log();
		$.ajax({
			url : "./course/addCourse",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
function removeCourse() {

	console.log("Login called");
	try {
		var course = new Object();
		course.userName = $('#userName').val();
		course.password = $('#pwd').val();

		console.log();
		$.ajax({
			url : "./course/addCourse",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
function eodCourse() {

	console.log("Login called");
	try {
		var course = new Object();
		course.userName = $('#userName').val();
		course.password = $('#pwd').val();

		console.log();
		$.ajax({
			url : "./course/addCourse",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
function getAllCoursesByActiveIndicator(flag) {

	console.log("Login called");
	try {
		var course = new Object();
		course.userName = $('#userName').val();
		course.password = $('#pwd').val();

		console.log();
		$.ajax({
			url : "./course/getAllCourses/"+flag,
			type : 'GET',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
function getAllCourses() {

	console.log("Login called");
	try {
		var course = new Object();
		course.userName = $('#userName').val();
		course.password = $('#pwd').val();

		console.log();
		$.ajax({
			url : "./course/addCourse",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(course),
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
					} else {console.log("Sorry, your browser does not support Web Storage...");}
				}else{}
			},

			error : function(data, status, er) {
				console.log("error: " + JSON.stringify(data) + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
	window.location="../admin.html";
}
