<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.12.2021
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>Sortuj po kategorii:</div>
<ul>
    <c:forEach items="${categories}" var="category">
        <li>${category.name}</li><a href="/showAllByCat/${category.id}">Sortuj</a>
    </c:forEach>
</ul>
<table>
    <tbody>
    <tr>
        <td>Nazwa produktu</td>
        <td>Opis produktu</td>
        <td>Cena produktu</td>
        <br/>
        <br/>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><a href="/product/order/add/${product.id}">Dodaj do koszyka</a> </td>
            <br/>
        </tr>
        <br/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
