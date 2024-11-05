<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAKR Solutions List</title>
</head>
<body>
<h2>DAKR Solutions List</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="dakrSolutions" items="${dakrSolutionsList}">
        <tr>
            <td>${dakrSolutions.id}</td>
            <td>${dakrSolutions.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
