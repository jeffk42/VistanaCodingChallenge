<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
		$("#titletable").fadeIn(600);
        $("#rowhead").fadeIn(800);
        $('[id^="row"]').fadeIn(1000);
        $("#buttonrow").fadeIn(1600);
        $("#homerow").fadeIn(1600);
   
});
</script> 
</head>

<body>

	<form:form id="regForm" modelAttribute="user" action="register-complete"
		method="post">
 
		<table align="center" id="titletable" style="display:none">
			<tr>
				<td>Complete Registration For User: </td>
				<td><b><c:out value="${sessionScope.user.username}" /></b></td>
			</tr>
		</table>

			<br /><br />
		<table align="center">
			<tr id="rowhead" style="display:none"><th>Security Question</th><th>Answer</th></tr>
			<c:forEach items="${sessionScope.user.securityQuestions}" varStatus="lcv">
            <tr id="row${lcv.index}" style="display:none">
            	<td>
            		<form:select path="securityQuestions[${lcv.index}]" name="securityQuestions[${lcv.index}]" id="securityQuestions[${lcv.index}]">
            			<c:forEach items="${secQuestions}" var="question">
            				<option value="${question}">${question}</option>
            			</c:forEach>
            		</form:select>
            	</td>
            	<td>
            		<form:input path="securityAnswers[${lcv.index}]" name="securityAnswers[${lcv.index}]" id="securityAnswers[${lcv.index}]" />
            	</td>

            </tr>
            </c:forEach>
 
			<tr id="buttonrow" style="display:none">
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr id="homerow" style="display:none">
				<td>
					<form:hidden path="username" id="username" name="username" />
					<form:hidden path="birthMonth" id="birthMonth" name="birthMonth" />
					<form:hidden path="birthDay" id="birthDay" name="birthDay" />
					<form:hidden path="birthYear" id="birthYear" name="birthYear" />
				</td>
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
