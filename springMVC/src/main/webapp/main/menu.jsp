<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/19
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>简单餐饮菜单界面</title>
    <style>
        /* 这里可以添加一些基本的CSS样式 */
        body {
            font-family: Arial, sans-serif;
        }

        .menu-container {
            max-width: 800px;
            margin: 0 auto;
        }

        .menu-item h3 {
            margin: 0;
        }

        .menu-item p {
            margin: 5px 0;
        }

        input[type="button"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="button"]:hover {
            background-color: #45a049;
        }

        table, th, td {
            border: 1px solid black; /* 设置边框为1像素宽的黑色实线 */
        }
        img{
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="menu-container">
    <div>
        <input type="button" onclick='location.href="<%=basePath%>DishServlet?op=toadd"' value="添加菜品"/>
    </div>
    <table id="dataList">
        <thead>
        <tr>
            <th>菜品id</th>
            <th>菜品名称</th>
            <th>价格</th>
            <th>图片</th>
            <th>简介</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.dname}</td>
                <td>${item.price}</td>
                <td><img src="<%=basePath%>img/${item.pic}"></td>
                <td>${item.details}</td>
                <th>
                    <button type="button" onclick='location.href="<%=basePath%>DishServlet?op=toupdate&id=${item.id}"'>
                        编辑
                    </button>
                    <button type="button" onclick='location.href="<%=basePath%>DishServlet?op=delete&id=${item.id}"'>
                        删除
                    </button>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
