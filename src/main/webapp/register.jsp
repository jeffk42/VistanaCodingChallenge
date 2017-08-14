<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration</title>
<script>
	function checkValues() {
	    var nm = document.getElementById("username").value;
	    var bm = document.getElementById("birthMonth").value;
		var bd = document.getElementById("birthDay").value;
		var by = document.getElementById("birthYear").value;
		
		
	    if (nm.length < 5 || nm.length > 12 || !nm.match(/^[0-9a-zA-Z]+$/)) {
	        alert("Username must be between 5 an 12 characters and consist of only alphanumeric characters.");
	        return false;
	    }
	    else if (bm.length < 1 || bm < 1 || bm > 12 || !bm.match(/^[0-9]+$/)) {
			alert("You have entered an invalid birth month. Please try again.");
			return false;
		}
		else if (bd.length < 1 || bd < 1 || bd > 31 || !bd.match(/^[0-9]+$/)) {
			alert("You have entered an invalid day of birth. Please try again.");
			return false;
		}
		else if (((bm == 4 || bm == 6 || bm == 9 || bm == 11) && bd > 30) ||
				(bm == 2 && bd > 29)) {
			alert("Hmm. That month doesn't have that many days. Try again.");
			return false;
		}
	}
	
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
		$("#row0").fadeIn(600);
        $("#row1").fadeIn(1000);
        $("#row2").fadeIn(1200);
        $("#row3").fadeIn(1400);
        $("#row4").fadeIn(1600);
   
});
</script> 
</head>

<body>
	<table align="center"><tr id="row0" style="display:none"><td><h2>User Registration</h2></td></tr></table>
	<form:form id="regForm" modelAttribute="user" action="register-security"
		method="post" onsubmit="return checkValues()">

		<table align="center">
			<tr id="row1" style="display:none">
				<td><form:label path="username">Please enter a username:</form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr id="row2" style="display:none">
                <td>Please enter your birthday:</td>
                <td>
                    <form:input path="birthMonth" name="birthMonth" id="birthMonth" maxlength="2" size="2" /> / 
                    <form:input path="birthDay" name="birthDay" id="birthDay" maxlength = "2" size="2" /> / 
                    <form:input path="birthYear" name="birthYear" id="birthYear" maxlength="4" size="4" />
                </td>
            </tr>
			<tr id="row3" style="display:none">
				<td></td>
				<td><form:button id="register-security" name="register-security">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr id="row4" style="display:none">
				<td></td>
				<td><a href="index.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
	<br /><br />
	<table align="center">
		<tr><td id="errorElement" style="font-style: italic; color: red;">${errorMessage}</td>
	</table>
</body>

</html>
