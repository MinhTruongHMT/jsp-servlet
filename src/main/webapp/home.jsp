<%@ page import="com.truong.ecommerce.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ninja
  Date: 6/12/2024
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // Lấy danh sách người dùng từ ServletContext
    List<User> users = (List<User>) request.getServletContext().getAttribute("userList");
%>

<table>
    <tr>
        <th>Tên</th>
        <th>Email</th>
    </tr>
    <% for (User user : users) { %>
    <tr>
        <td><%= user.getId() %>
        </td>
        <td><%= user.getUsername() %>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
