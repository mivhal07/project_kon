<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 07.12.2021
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
    <a href="/login">Zaloguj</a><br/>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <a href="/register">Zarejestruj się</a><br/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</sec:authorize>
<form:form action="/product/showAllProducts" method="get">
    <input type="submit" value="Produkty">
</form:form>
<form:form action="/about" method="get">
    <input type="submit" value="O nas">
</form:form>
<form:form action="/contact" method="get">
    <input type="submit" value="Kontakt">
</form:form>
<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin/product/add">Dodaj produkt</a><br/>
    <a href="/admin/add">Dodaj admina</a><br/>
    <a href="/admin/addCategory">Dodaj kategorię</a>
</sec:authorize>
</body>
</html>
