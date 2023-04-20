<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <f:form action="logincheck" modelAttribute="login" >
            Enter Username: <f:input path="username"/><br/>
            Enter Password: <f:input path="password"/><br/>
            <input type="submit" value="login" /><br/>
        </f:form>
    </body>
</html>
