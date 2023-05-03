<%-- 
    Document   : studentlist
    Created on : May 3, 2023, 9:44:49 AM
    Author     : hcdc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    </head>
    <body>
        <jsp:include page="/navbar.jsp"/>
        <br/><br/>
        <h4>Student List</h4>
        <table class="table table-bordered">
              <thead>
                <tr>
                  <th scope="col">Student ID</th>
                  <th scope="col">First name</th>
                  <th scope="col">Last name</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach items="${studs}" var="student">
                      <tr>
                          <td>${student.getId()}</td>
                          <td>${student.getFname()}</td>
                          <td>${student.getLname()}</td>
                          <td><a href="viewdetails/${student.getId()}">View details</a></td>
                      </tr>
                  </c:forEach>
              </tbody>
        </table>
        <div class="pagination">
          <c:if test="${currentPage > 1}">
            <a href="<c:url value='/studs'><c:param name='page' value='${currentPage - 1}'/><c:param name='size' value='${size}'/></c:url>">&laquo; Previous</a>
          </c:if>

          <c:forEach begin="1" end="${totalPages}" var="pageNumber">
            <c:choose>
              <c:when test="${pageNumber == currentPage}">
                <span class="current-page">${pageNumber}</span>
              </c:when>
              <c:otherwise>
                <a href="<c:url value='/studs'><c:param name='page' value='${pageNumber}'/><c:param name='size' value='${size}'/></c:url>">${pageNumber}</a>
              </c:otherwise>
            </c:choose>
          </c:forEach>

          <c:if test="${currentPage < totalPages}">
            <a href="<c:url value='/studs'><c:param name='page' value='${currentPage + 1}'/><c:param name='size' value='${size}'/></c:url>">Next &raquo;</a>
          </c:if>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

    </body>
</html>
