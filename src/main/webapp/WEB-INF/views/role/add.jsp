<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 20.12.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding role</title>
</head>
<body>
<form:form modelAttribute="role">
    <label for="name">Nazwa roli</label>
    <form:input path="name"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
