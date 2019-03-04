<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://routines.itlbv.com/functions" %>
<html>
<head>
    <title>Routines</title>
</head>
<body>


<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Time of day</th>
    </tr>
    </thead>
    <jsp:useBean id="routines" scope="request" type="java.util.List"/>
    <c:forEach items="${routines}" var="routine">
        <jsp:useBean id="routine" type="com.itlbv.routines.model.Routine"/>
        <%--        <tr class="${meal.excess ? 'excess' : 'normal'}">     --%>
        <tr>
            <td>${routine.name}</td>
            <td>${routine.description}</td>
                <%-- <td>${fn:formatTime(routine.timeOfDay)}</td> --%>
            <td>${routine.timeOfDay}</td>
            <td><a href="routines?action=update&id=${routine.id}">Update</a></td>
            <td><a href="routines?action=delete&id=${routine.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
