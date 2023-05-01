<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
         <jsp:include page="/navbar.jsp"/>
            <div  class="d-flex flex-column justify-content-center align-items-center" enctype="multipart/form-data">
                <h4>Details</h4>
                <f:form action="savedetails" modelAttribute="stddetails" >
                    
                    <%--<f:input type="hidden" id="student" name="student" path="student" value="${student}"/>--%>
                    
                   
                    <div class="form-group">
                         <label for="fullName">Full Name:</label>
                         <f:input type="text" class="form-control" id="fullName" name="fullName" path="full_name" placeholder="Enter Full Name"/><br><br>
                    </div>
                    <div class="form-group">
                         <label for="fullName">Department</label>
                         <f:input type="text" class="form-control" id="dept" name="dept" path="dept" placeholder="Enter Department"/><br><br>
                    </div>
                    <div class="form-group">
                         <label for="fullName">Email</label>
                         <f:input type="text" class="form-control" id="email" name="email" path="email" placeholder="Enter email"/><br><br>
                    </div>
                    <div class="form-group">
                         <label for="fullName">Phone</label>
                         <f:input type="text" class="form-control" id="phone" name="phone" path="phone_no" placeholder="Enter phone no."/><br><br>
                    </div>
                    <div class="form-group">
                         <label for="fullName">Photo</label>
                         <f:input type="file" class="form-control" id="photo" name="photo" path="photo" placeholder="Upload photo"/><br><br>
                    </div>
                   
                    <button type="submit" class="btn btn-primary">Update</button>
                    
                </f:form>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
