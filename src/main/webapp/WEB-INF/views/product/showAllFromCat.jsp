<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 19.12.2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td>Nazwa produktu</td>
        <td>Opis produktu</td>
        <td>Cena produktu</td>
        <br/>
        <br/>
    </tr>
    <c:forEach items="${productsByCat}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><a href="/cart/add?id=${product.id}">Dodaj do koszyka</a> </td>
            <br/>
        </tr>
        <br/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
