<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/own-enterprises/submit" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    
    <label for="employeeCount">Employee Count:</label>
    <input type="number" id="employeeCount" name="employeeCount" required>
    
    <label for="clientTargets">Client Targets:</label>
    <input type="text" id="clientTargets" name="clientTargets" required>
    
    <label for="projectQuality">Project Quality:</label>
    <input type="text" id="projectQuality" name="projectQuality" required>
    
    <label for="clientSatisfaction">Client Satisfaction:</label>
    <input type="text" id="clientSatisfaction" name="clientSatisfaction" required>
    
    <input type="submit" value="Submit">
</form>


</body>
</html>