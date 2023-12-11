<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="/student" method="post">
    <label>
        <input type="text" name="key">
    </label>
    <button>Search</button>
</form>

</h1>
<br/>
    <a href="/student?list">1.Danh sách sinh viên</a>
<%--<h1>===== MENU =====</h1>--%>
<%--<h2>--%>
<%--</h2>--%>
<%--<h2>--%>
<%--    <a href="/student?createForm">2.Thêm mới</a>--%>
<%--</h2>--%>
<%--<h2>--%>
<%--    <a href="/student?editForm">3.Cập nhật</a>,--%>
<%--</h2>--%>
<%--<h2>--%>
<%--    <a href="/student?delete">4.Xóa</a>--%>
<%--</h2>--%>
<%--<h2>5.Sắp xếp</h2>--%>
<%--<h2>6.Đọc từ file</h2>--%>
<%--<h2>7.Ghi vào file</h2>--%>
<%--<h2>8.Exit</h2>--%>
</body>
</html>