<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.01.2022
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
<div style="color: red">Pamiętaj że przy usuwaniu usuniesz wszystkie produkty z tej kategorii!!!<br/>
    Najpierw zrób porządek z produktami z danej kategorii</div>
<br/>
<table>
    <tbody>
    <tr>
        <td>Nazwa Kategorii</td>
        <td>Akcje</td>
            <br/>
            <br/>
    </tr>
    <c:forEach items="${categories}" var="cat">
        <tr>
            <td>${cat.name}</td>
            <td><a href="/admin/category/update/${cat.id}">Edytuj</a><br/>
                <a href="/admin/category/delete/${cat.id}">Usuń</a><br/>
        </tr>
        <br/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
