
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light py-3">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Student Admin System</a>
        <ul class="navbar-nav justify-content-right">
            <c:choose>
                <c:when test="${user.getRole() == 'ADMIN'}">
                  <li class="nav-item ">
                    <a class="nav-link" href="<c:url value="#" />">Students List</a>
                  </li>
                  <li class="nav-item ">
                    <a class="nav-link" href="<c:url value="#" />">Manage Roles</a>
                  </li>  
                  <li class="nav-item ">
                    <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                  </li>
                </c:when>
                <c:when test="${user.getRole() == 'STUDENT'}">
                  <li class="nav-item ">
                    <a class="nav-link" href="#">Manage Details</a>
                  </li>  
                  <li class="nav-item ">
                    <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                  </li>                    
                </c:when>   
                <c:otherwise>
                  <li class="nav-item ">
                    <a class="nav-link" href="login/admin">Admin Login</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="login/student">Student Login</a>
                  </li>
                </c:otherwise>                
            </c:choose>

          
        </ul>
    </div>
</nav>
