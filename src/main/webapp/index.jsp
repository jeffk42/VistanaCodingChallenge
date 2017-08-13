<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>

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
</head>

<body>
	
	<table align="center">
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