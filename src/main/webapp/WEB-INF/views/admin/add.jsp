<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.12.2021
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Admin</title>
</head>
<body>
<form:form method="post"
           modelAttribute="user">
    <label for="name">Login</label>
    <form:input path="username" id="name"/><br/>
    <form:errors path="username"/><br/>
    <label for="desc">Hasło</label>
    <form:input path="password" id="desc"/><br/>
    <form:errors path="password"/><br>
    <label for="quantity">Enabled</label>
    <form:input path="enabled" id="quantity"/><br/>
    <form:errors path="enabled"/><br/>
    <input type="submit" value="Save"><br/>
</form:form>
</body>
</html>
