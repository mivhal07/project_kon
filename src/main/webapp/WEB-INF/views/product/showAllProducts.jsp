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
<a href="/product/showAllKuchenne">Kuchenne</a>
<a href="/product/showAllDonice">Donice</a>
<a href="/product/showAllBiżuteria">Biżuteria</a>
<jsp:include page="bodyToShowProducts.jsp"/>
</body>
</html>
