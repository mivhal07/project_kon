<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.01.2022
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj Kategorię</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    <label>Nazwa Kategorii<form:input path="name"/></label>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</html>
