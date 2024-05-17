<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/23
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>点餐系统订单界面</title>
    <style>
        /* 这里可以添加样式代码 */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>点餐系统订单界面</h1>
<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
    <thead>
    <tr>
        <th class="sorting">订单号</th>
        <th class="sorting">订单状态</th>
        <th class="sorting">订单日期</th>
        <th class="sorting">顾客信息</th>
        <th class="sorting">菜品列表</th>
        <th class="sorting">数量</th>
        <th class="sorting">总价</th>
        <th class="sorting">结算</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item" varStatus="status">
        <tr>
            <td>${item.oid}</td>
            <td>${item.state}</td>
            <td>${item.odate}</td>
            <td>${item.userId}</td>
            <td>${item.dishId}</td>
            <td>${item.num}</td>
            <td>${item.tprice}</td>
        </tr>
        <td>
            <input type="button" value="结算"
                   onclick='location.href="<%=basePath%>OrderServlet?op=update?id=${item.oid}&uname=${item.userId}"'>
        </td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
