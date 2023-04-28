<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    </head>
    <body>
        <div  class="d-flex flex-column justify-content-center align-items-center">
        <h4>${user_type} Signup</h4>
        <f:form action="../save/${user_type}" modelAttribute="${user_type}">
                 <div class="form-group">
                    <label for="fname"> First name</label>
                    <f:input type="text" class="form-control" id="fname" path="fname" placeholder="Enter first name"/><br/>
                 </div>
                  <div class="form-group">
                    <label for="lname"> Last name</label>
                    <f:input type="text" class="form-control" id="lname" path="lname" placeholder="Enter Last name"/><br/>
                 </div>
                 <div class="form-group">
                    <label for="fname"> Username</label>
                    <f:input type="text" class="form-control" id="uname" path="username" placeholder="Enter username"/><br/>
                 </div>
                 <div class="form-group">
                    <label for="pwd"> Password</label>
                    <f:input type="password" class="form-control" id="pwd" path="password" placeholder="Enter passowrd"/><br/>
                 </div>
		
		<input type="submit"  class="btn btn-primary" value="Signup" />
	</f:form>
        <div/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

    </body>
</html>
