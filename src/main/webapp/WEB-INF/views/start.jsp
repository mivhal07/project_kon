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
    <a href="/login">Zaloguj</a><br/><br/>
    <a href="/register">Zarejestruj się</a><br/><br/>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj"><br/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</sec:authorize>

<a href="/product/showAllProducts">Produkty</a><br/><br/>
<a href="/about">O nas</a><br/><br/>
<a href="/contact">Kontakt</a><br/><br/>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin/product/add">Dodaj produkt</a><br/><br/>
    <a href="/admin/add">Dodaj admina</a><br/><br/>
    <a href="/admin/category/addCategory">Dodaj kategorię</a><br/><br/>
    <a href="/admin/category/categories">Zaktualizuj kategorię</a>
</sec:authorize>
</body>
</html>
