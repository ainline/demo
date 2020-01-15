<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/1/11
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>

    <script type="text/javascript" src="js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "ajax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name": "chen"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // alert();
                        console.log(data)
                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>测试</h1>
<a href="void">测试转发</a><br>
<a href="modelAndView">返回ModelAndView</a><br>
<a href="forwardOrRedirect">转发和重定向</a><br>
<button id="btn">发送ajax</button><br>
<a href="exception">自定义异常类</a><br>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="普通上传" />
</form>

<form action="uploadMVC" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <input type="submit" value="MVC上传" />
</form>

<form action="save" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    时间：<input type="text" name="date"><br>
    <%--    账号：<input type="text" name="card"><br>--%>
    <%--    金额：<input type="text" name="money"><br>--%>
    <h2>对象参数</h2>
    账号：<input type="text" name="account.card"><br>
    金额：<input type="text" name="account.money"><br>
    <h2>列表</h2>
    账号：<input type="text" name="list[0].card"><br>
    金额：<input type="text" name="list[0].money"><br>
    账号：<input type="text" name="map['1'].card"><br>
    金额：<input type="text" name="map['1'].money"><br>

    <input type="submit" value="commit">
</form>
</body>
</html>
