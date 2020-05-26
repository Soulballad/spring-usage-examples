<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>user list</title>
</head>
<body>
    <div>
        <button><a href="/user/detail/0">新增</a></button>
        <table style="width: 1000px;height: auto" cellpadding="1" cellspacing="1" broder="solid">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>地址</th>
                <th>生日</th>
                <th>手机</th>
                <th>操作</th>
            </tr>
             <#list userList as user >
                <tr>
                    <td>${user.id!}</td>
                    <td>${user.name!}</td>
                    <td>${user.age!}</td>
                    <td>${user.address!}</td>
                    <td>${user.birthday!}</td>
                    <td>${user.phone!}</td>
                    <td>
                        <a href="/user/detail/${user.id}">修改</a>
                        <a href="/user/delete/${user.id}">删除</a>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</body>
</html>