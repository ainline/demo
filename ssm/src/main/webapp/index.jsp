<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/1/16
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm测试</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "user/find",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"id": 1}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // alert();
                        console.log(data)
                        document.getElementById("result").innerHTML = data;
                    }
                });
            });
        });
    </script>
</head>
<body>
<button type="button" id="btn">查询一个</button>
<div id="result"></div>
</body>
</html>
