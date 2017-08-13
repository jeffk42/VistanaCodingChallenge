<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Page Login</title>
</head>

<body>

	<form:form id="loginForm" modelAttribute="login" action="login-security"
		method="post">
		<table align="center">
			<tr>
				<td>Username Selected: </td>
				<td><b>${param.username}</b></td>
			</tr>
			<tr>
				<td>
					<form:hidden path="username" id="username" name="username" />
				</td>
			</tr>
			<tr>
				<td><form:hidden path="securityQuestion" id="securityQuestion" name="securityQuestion" />
				<form:label path="securityQuestion">${login.securityQuestion}</form:label></td>
				<td><form:input path="securityAnswer" id="securityAnswer"/></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Login</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="index.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
	<br /><br />
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${errorMessage}</td>
		</tr>
	</table>
</body>
</html>