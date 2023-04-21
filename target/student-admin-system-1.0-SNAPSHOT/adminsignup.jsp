<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Signup</h1>
        <f:form action="save" modelAttribute="admin">
		Enter first name : <f:input path="fname"/> <br/>
		Enter last name : <f:input path="lname"/> <br/>
		Enter username : <f:input path="username"/> <br/>
		Enter password : <f:input path="password"/> <br/>
		<input type="submit" value="Signup" />
	</f:form>
    </body>
</html>
