<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Main Page</title>

<script>
function userprompt() {
	document.getElementById("errorElement").innerHTML="";
    var user = prompt("Please enter your username:", "");
    if (user != null && user != "" && user.length >= 5 && user.length <= 12 && user.match(/^[0-9a-zA-Z]+$/)) {
    	window.location = "login?username="+user;
    }
    else {
    	document.getElementById("errorElement").innerHTML="Please enter a valid username between 5 and 12 alphanumeric characters.";
    }
    return;
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
    
        $("#welcomeheader").fadeIn(1000);
        $("#choosetext").fadeIn(1000);
        $("#buttonTable").fadeIn(1500);
   
});
</script> 
</head>

<body>
	<table align="center">
		<tr><td align="center"><h2 id="welcomeheader" style="display:none">Welcome to the site!</h2></td></tr>
		<tr><td align="center"><span id="choosetext" style="display:none">Please choose an option below:</span></td></tr>
	</table>
	<br /><br />
	<table align="center" id="buttonTable" style="display:none">
		<tr>
			<td><button onclick="userprompt()">Login</button></td>
			<td><button onclick="window.location='register'">Sign Up</button></td>
		</tr>
	</table>
	<br /><br />
	<table align="center">
		<tr><td id="errorElement" style="font-style: italic; color: red;">${errorMessage}</td>
	</table>

</body>

</html>