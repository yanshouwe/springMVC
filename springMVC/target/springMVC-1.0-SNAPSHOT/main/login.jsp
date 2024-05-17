<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2024/4/9
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 100px;
        }

        h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .form-group input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        .form-group input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<div class="container">
    <h2>用户登录</h2>
    <div class="form-group">
        <label for="uname">用户名:</label>
        <input type="text" id="uname" name="uname" required>
    </div>
    <div class="form-group">
        <label for="pwd">密码:</label>
        <input type="password" id="pwd" name="pwd" required>
    </div>
    <div class="form-group">
        <input type="button" onclick='location.href="<%=basePath%>RegisterServlet"' value="注册"/>
        <input type="submit" onclick="tijiao()" value="登录"/>
        <span>${msg}</span>
    </div>
</div>
</body>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    function tijiao() {
        var uname = document.getElementById("uname").value;
        var pwd = document.getElementById("pwd").value;
        if (uname == null || uname == "") {
            alert("用户名不能为空")
            return false;
        }
        if (pwd == null || pwd == "") {
            alert("密码不能为空")
            return false;
        }
        $.ajax({
            url: "<%=basePath%>LoginServlet", // 请求路径
            type: "POST", //请求方式
            data: {"uname": uname, "pwd": pwd},//请求参数
            success: function (msg) {
                if (msg == 1) {
                    window.location.href = "<%=basePath%>DishServlet?op=list";
                } else if (msg == 0) {
                    alert("登陆失败！！");
                } else {
                    window.location.href = "<%=basePath%>main/error.jsp";
                }
            }
        });
    }
</script>
</html>

