<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2022/11/22
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello SpringBoot</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1-min.js"></script>
    <script type="text/javascript">
        function post (user) {
            const url = "./save";
            $.post({
                url: url,
                contentType: "application/json",
                data: JSON.stringify(user),
                success: function (result, status) {
                    if (result == null || result.id == null) {
                        alert("插入失败");
                        return;
                    }
                }
            });
        }

        for (let i = 1; i <= 10; i++) {
            const user = {
                'id'       : i,
                'userName' : 'user_name_' + i,
                'note'     : 'note_' + i,
                'roles'    : [{
                    'id'       : i,
                    'roleName' : 'role_' + i,
                    'note'     : 'note_' + i
                }, {
                    'id'       : i + 1,
                    'roleName' : 'role_' + (i + 1),
                    'note'     : 'note_' + (i + 1)
                }]
            };
            post(user);
        }
    </script>
</head>
<body>
    <h1>操作 MongoDB 文档</h1>
</body>
</html>
