<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product add</title>
</head>
<body>

<form:form method="post"
           modelAttribute="product">
    <label for="name">Nazwa Produktu</label>
    <form:input path="name" id="name"/><br/>
    <form:errors path="name"/><br/>
    <label for="description">Opis produktu</label>
    <form:input path="description" id="description"/><br/>
    <form:errors path="description"/><br>
    <label for="quantity">Ilość</label>
    <form:input path="quantity" id="quantity"/><br/>
    <form:errors path="quantity"/><br/>
    <label for="price">Cena produktu</label>
    <form:input path="price" id="price"/><br/>
    <form:errors path="price"/><br/>
    <label>Kategoria
        <form:select itemValue="id" itemLabel="name" path="category.id" items="${categories}"/>
    </label><br/>
    <input type="submit" value="Save"><br/>
</form:form>

</body>
</html>