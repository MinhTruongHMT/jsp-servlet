<%@ page import="com.truong.ecommerce.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: ninja
  Date: 6/12/2024
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) request.getServletContext().getAttribute("user");
%>
<h1><%=user.getId()%></h1>
<p><%=user.getUsername()%></p>
</body>
</html>
