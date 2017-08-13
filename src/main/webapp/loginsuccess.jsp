    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

        <html>

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

            <title>Welcome, ${sessionScope.user.username}!</title>

        </head>

        <body>

			<table align="center">
				<tr>
					<td>You are now logged in, ${sessionScope.user.username}!</td>
				</tr>
			</table>
			
			<br /><br />
			
			<table align="center" width="75%">
				<tr>
					<th>Detail</th><th>Value</th>
				</tr>
				<tr>
					<td>Username</td><td>${sessionScope.user.username}</td>
				</tr>
				<tr>
					<td>Birthday</td><td>${sessionScope.user.birthMonth}/${sessionScope.user.birthDay}/${sessionScope.user.birthYear}</td>
				</tr>
			</table>
			<br /><br />
			<table align="center">
				<tr><td colspan="2"><a href="index.jsp">Return to Main Page</a></td></tr>
			</table>

                        



        </body>

        </html>