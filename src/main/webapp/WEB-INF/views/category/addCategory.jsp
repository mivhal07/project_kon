<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 19.12.2021
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
<label for="name">Nazwa kategorii:</label><br/>
<form:form modelAttribute="category">
    <form:input type="text" id="name" placeholder="Nazwa" path="name"/>
    <input type="submit" value="Zapisz">
</form:form>
<ul>
    <c:forEach items="${categories}" var="category">
        <li>
            <div>${category.name}</div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
