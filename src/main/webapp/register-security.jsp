<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration</title>

</head>

<body>

	<form:form id="regForm" modelAttribute="user" action="register-complete"
		method="post">

		<table align="center">
			<tr>
				<td>Username: </td>
				<td><b><c:out value="${sessionScope.user.username}" /></b></td>
			</tr>
		</table>

			
		<table align="center">
			<tr><th>Security Question</th><th>Answer</th></tr>
            <tr>
            	<td>
            		<form:select path="security1" name="security1" id="security1">
            			<c:forEach items="${secQuestions}" var="question">
            				<option value="${question}">${question}</option>
            			</c:forEach>
            		</form:select>
            	</td>
            	<td>
            		<form:input path="answer1" name="answer1" id="answer1" />
            	</td>

            </tr>
            <tr>
            	<td>
            		<form:select path="security2" name="security2" id="security2">
            			<c:forEach items="${secQuestions}" var="question">
            				<option value="${question}">${question}</option>
            			</c:forEach>
            		</form:select>
            	</td>
            	<td>
            		<form:input path="answer2" name="answer2" id="answer2" />
            	</td>

            </tr>
            <tr>
            	<td>
            		<form:select path="security3" name="security3" id="security3">
            			<c:forEach items="${secQuestions}" var="question">
            				<option value="${question}">${question}</option>
            			</c:forEach>
            		</form:select>
            	</td>
            	<td>
            		<form:input path="answer3" name="answer3" id="answer3" />
            	</td>
            </tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
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
