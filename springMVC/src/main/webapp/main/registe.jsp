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
    <title>注册界面</title>
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
    <h2>注册</h2>
    <input type="text" name="uname" placeholder="用户名" id="uname" onkeyup="jiaoyan()">
    <input type="password" name="pwd" placeholder="密码" id="pwd">
    <select name="role" id="role">
        <option selected="selected" value="0">请选择角色</option>
        <option value="1">管理员</option>
        <option value="2">商家</option>
        <option value="3">用户</option>
    </select>
    <input type="text" name="tel" placeholder="电话" id="tel" required>
    <input type="submit" value="注册" onclick="tijiao()">
    <span id="unamespan" style="color:red;font-size: 8px"/>
</div>
</body>
</html>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script>
    function jiaoyan() {
        debugger;
        var uname = document.getElementById("uname").value;
        if (uname == null || uname.trim() == "") {
            return false;
        }
        var unamespan = document.getElementById("unamespan");
        unamespan.innerHTML = " ";
        $.ajax({
            url: "<%=basePath%>UnamejiaoyanServlet", // 请求路径
            type: "POST", //请求方式
            data: {"uname": uname},//请求参数
            success: function (msg) {
                if (msg == 0) {
                    unamespan.innerHTML = "用户名存在";
                } else if (msg == 1){
                    unamespan.innerHTML = "用户名不存在";
                }else {
                    window.location.href = "<%=basePath%>main/error.jsp";
                }
            }
        });
    }

    function tijiao() {
        var uname = document.getElementById("uname").value;
        var pwd = document.getElementById("pwd").value;
        var role = document.getElementById("role").value;
        var tel = document.getElementById("tel").value;
        if (uname == null || uname == "") {
            alert("用户名不能为空")
            return false;
        }
        if (pwd == null || pwd == "") {
            alert("密码不能为空")
            return false;
        }
        if (role == 0) {
            alert("请选择角色")
            return false;
        }
        if (tel == null || tel == "") {
            alert("电话不能为空")
            return false;
        }
        $.ajax({
            url: "<%=basePath%>RegisterServlet", // 请求路径
            type: "POST", //请求方式
            data: {"uname": uname, "pwd": pwd,"role":role,"tel":tel},//请求参数
            success: function (msg) {
                if (msg == 1) {
                    window.location.href = "<%=basePath%>main/login.jsp";
                } else if (msg == 0) {
                    alert("注册失败！！");
                } else {
                    window.location.href = "<%=basePath%>main/error.jsp";
                }
            }
        });
    }
</script>
