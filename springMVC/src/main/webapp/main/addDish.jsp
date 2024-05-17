<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/12
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<html>
<head>
    <title>添加菜品信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<div class="container">
    <h2>添加菜品</h2>
    <form action="<%=basePath%>DishServlet?op=add" method="post">
        <div>id</div>
        <div>
            <input type="text" placeholder="id" name="id" value="${dish.id}">
        </div>

        <div>菜品名称</div>
        <div>
            <input type="text" placeholder="菜品名称" name="dname" value="${dish.dname}">
        </div>

        <div>价格</div>
        <div>
            <input type="text" placeholder="价格" name="price" value="${dish.price}">
        </div>
        <div>图片</div>
        <div>
            <input type="text" placeholder="图片" name="pic" value="${dish.pic}">
        </div>
        <div>简介</div>
        <div>
            <input type="text" placeholder="价格" name="details" value="${dish.details}">
        </div>
        <button type="submit">保存</button>
    </form>
</div>
</body>
</html>
