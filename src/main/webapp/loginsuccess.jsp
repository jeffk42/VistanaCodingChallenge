  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

      <html>

      <head>

          <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

          <title>Welcome, ${sessionScope.user.username}!</title>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script> 
	$(document).ready(function(){
			$("#titletable").fadeIn(600);
	        $("#datatable").fadeIn(1200);
	        $("#hometable").fadeIn(1500);
	});
	</script>

      </head>

      <body>

	<table align="center" id="titletable" style="display:none">
		<tr>
			<td>You are now logged in, ${sessionScope.user.username}!</td>
		</tr>
	</table>
	
	<br /><br />
	
	<table align="center" border="1" id="datatable" style="display:none">
		<tr>
			<th align="left">Detail</th><th align="left">Value</th>
		</tr>
		<tr>
			<td>Username</td><td>${sessionScope.user.username}</td>
		</tr>
		<tr>
			<td>Birthday</td><td>${sessionScope.user.birthMonth}/${sessionScope.user.birthDay}/${sessionScope.user.birthYear}</td>
		</tr>
	</table>
	<br /><br />
	<table align="center" id="hometable" style="display:none">
		<tr><td colspan="2"><a href="index.jsp">Return to Main Page</a></td></tr>
	</table>

                      



      </body>

      </html>