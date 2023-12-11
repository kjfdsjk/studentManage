<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student?action=create">Create new product</a>
<form action="/student" method="post">
    <label>
        <input type="text" name="key">
    </label>
    <button>Search</button>
</form>

<c:forEach items='${danhsach}' var="student">
    <h3>${student.id},${student.name},${student.age},${student.gender},${student.address},,${student.averageScore}
        <a href="/student?action=edit&id=${student.id}">Edit</a>,
        <a href="/student?action=delete&id=${student.id}">Delete</a>
    </h3>
</c:forEach>
<a href="/student?action=sortUp">SortUp</a>
<a href="/student?action=sortDown">SortDown</a>
</body>
</html>
