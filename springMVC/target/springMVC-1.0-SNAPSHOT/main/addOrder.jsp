<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/26
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath() + "/";
    String date = new Date().toLocaleString();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订餐系统 - 添加订单</title>
    <style>
        /* 简单的样式 */
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>订餐系统 - 添加订单</h1>
    <form action="<%=basePath%>OrderServlet?op=add" method="post"> <!-- 替换为你的实际提交URL -->
        <label>时间:</label>
        <input type="text" id="odate" name="odate" value="<%=date%>" readonly required>
        <label>菜品名称:</label>
        <input type="text" id="dname" name="dname" value="${dish.dname}" readonly required>
        <label>菜品价格:</label>
        <input type="text" id="price" name="price" value="${dish.price}" readonly required>
        <label>用户名称:</label>
        <input type="text" name="uname" value="${uname}" readonly required>
        <label>数量:</label>
        <input type="number" id="num" name="num" required>

        <button type="submit">提交订单</button>
    </form>
</div>
</body>
</html>
