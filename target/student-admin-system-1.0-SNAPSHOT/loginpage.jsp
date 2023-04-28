<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
            <jsp:include page="/navbar.jsp"/>
            <div  class="d-flex flex-column justify-content-center align-items-center">
                <h4>Login</h4>
                <f:form action="../logincheck/${user_type}" modelAttribute="login" >
                    <div class="form-group">
                         <label for="uname">Username</label>
                         <f:input type="text" class="form-control" id="uname" path="username" placeholder="Enter Username"/><br/>
                    </div>
                    <div class="form-group">
                         <label for="pwd">Password</label>
                         <f:input type="password" class="form-control" id="pwd" path="password" placeholder="Enter Password"/><br/>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <c:if test="${user_type == 'student'}">
                        <div class="text-center">
                            <p>Don't have an account? <a href="../signup/${user_type}">Register</a></p>
                        </div>
                    </c:if>
                    
                </f:form>
                
            </div>
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
