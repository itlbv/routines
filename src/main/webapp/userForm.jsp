<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.action == 'create' ? 'Create user' : 'Edit user'}</title>
</head>
<body>

<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>${param.action == 'create' ? 'Create user' : 'Edit user'}</h2>
    <hr>
    <jsp:useBean id="user" type="com.itlbv.routines.model.User" scope="request"/>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="registeredTimeDate" value="${user.registeredTimeDate}">
        <dl>
            <dt>Name:</dt>
            <dd>po<input type="text" value="${user.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${user.email}" size=40 name=email" required></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input type="text" value="${user.password}" size=40 name="password" required></dd>
        </dl>
        <dl>
            <dt>Role:</dt>
            <dd><input type="text" value="${user.role}" size=40 name="role" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>

</body>
</html>
