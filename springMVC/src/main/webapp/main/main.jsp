<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/9
  Time: 15:16
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
    <title>首页</title>
    <style>
        /* 这里可以添加一些基本的CSS样式 */
        body {
            font-family: Arial, sans-serif;
        }

        .menu {
            background-color: #f8f9fa;
            padding: 10px;
        }

        .menu ul {
            list-style-type: none;
            padding: 0;
        }

        .menu li {
            display: inline;
            margin-right: 10px;
        }

        .footer {
            text-align: center;
            padding: 10px;
            background-color: #f8f9fa;
        }

        table, th, td {
            border: 1px solid black; /* 设置边框为1像素宽的黑色实线 */
        }

        .purchasenumber {
            width: 100%;
            height: 25%;
            display: flex;
            align-items: center;
            justify-content: space-between;
            border-bottom: 1px solid #f1f1f1;
        }

        .purchasenumber .number i,
        .purchasenumber .number input {
            display: inline-block;
            height: 0.6rem;
            line-height: 0.6rem;
            font-size: 0.2rem;
            text-align: center;
            border: 1px solid #515151;
            color: #323232;
        }

        .purchasenumber .number i {
            width: 0.6rem;
        }

        .purchasenumber .number input {
            width: 0.8rem;
            vertical-align: top;
            margin-left: -0.08rem;
            border-left-style: none;
            box-sizing: content-box;
        }

        .purchasenumber .number .minus {
            border-radius: 0.06rem 0 0 0.06rem;
        }

        .purchasenumber .number .plus {
            margin-left: -0.08rem;
            border-radius: 0 0.06rem 0.06rem 0;
            border-left-style: none;
        }

        img {
            width: 200px;
            height: 200px;
        }

        #number {
            width: 50px;
        }

        .anniu button {
            display: inline-block;
        }

        h1 {
            text-align: center;
        }

        * {
            padding: 0px;
            margin: 0px;
        }

        li {
            list-style: none;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
</script>
<body>
<div class="menu">
    <ul>
        <li><a href="<%=basePath%>DishServlet?op=list">首页</a></li>
        <li><a href="<%=basePath%>DishServlet?op=mlist">菜单</a></li>
        <li><a href="#">预订</a></li>
        <li><a href="#">关于我们</a></li>
    </ul>
</div>

<h1>${user.uname}欢迎来到我们的餐厅！</h1>
<input type="button" onclick='location.href="<%=basePath%>main/order.jsp"' value="查看订单">
<div class="menu-container">
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
        <thead>
        <tr>
            <th class="sorting">菜品id</th>
            <th class="sorting">菜品名称</th>
            <th class="sorting">价格</th>
            <th class="sorting">图片</th>
            <th class="sorting">简介</th>
            <th class="sorting">操作</th>
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
                <td>
                    <input type="button" value="加入订单" onclick='location.href="<%=basePath%>OrderServlet?op=toadd&id=${item.id}&uname=${user.uname}"'/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="footer">
    版权所有 &copy; 202112104029ysw
</div>
</body>
</html>
