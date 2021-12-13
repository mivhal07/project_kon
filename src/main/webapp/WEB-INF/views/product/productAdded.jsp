<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 07.12.2021
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Added</title>
</head>
<body>
Product Added
<br/>
<br/>
<form:form action="/product/add" method="get">
    <input type="submit" value="Dodaj jeszcze produkt"/>
</form:form>

</body>
</html>
