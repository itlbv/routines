<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit routine</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>${param.action == 'create' ? 'Create routine' : 'Edit routine'}</h2>
    <hr>
    <jsp:useBean id="routine" type="com.itlbv.routines.model.Routine" scope="request"/>
    <form method="post" action="routines">
        <input type="hidden" name="id" value="${routine.id}">
        <dl>
            <dt>Name:</dt>
            <dd>po<input type="text" value="${routine.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${routine.description}" size=40 name="description" required></dd>
        </dl>
        <dl>
            <dt>Time of day:</dt>
            <dd><input type="time" value="${routine.timeOfDay}" name="timeOfDay" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
