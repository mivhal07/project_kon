<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.01.2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja</title>
</head>
<body>
<form:form method="post" modelAttribute="product">
    <form:hidden path="id"/>
    <label>Nazwa produktu<br/><form:input path="name"/></label><br/><br/>
    <label>Cena produktu<br/><form:input path="price"/></label><br/><br/>
    <label>Ilość produktu<br/><form:input path="quantity"/></label><br/><br/>
    <label>Opis produktu<br/><form:input path="description"/></label><br/><br/>
    <label>Kategoria
        <form:select itemValue="id" itemLabel="name" path="category.id" items="${categories}"/>
    </label><br/>
    <input type="submit" value="Save"><br/>
</form:form>
</body>
</html>
