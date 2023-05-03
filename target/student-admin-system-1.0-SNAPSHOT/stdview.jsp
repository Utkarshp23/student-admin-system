<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!--Remaains unDone-->
        <p>${stddet.getFull_name()}</p>
<!--        <img  src="${pageContext.request.contextPath}/showphoto/${stddet.getId()}/>" />-->
        <img src="data:image/jpeg;base64,${userImage}" />
    </body>
</html>
