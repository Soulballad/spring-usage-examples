<!DOCTYPE html>
<html>
    <head>
        <title>user add&edit</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form name="addForm" action="/user/add" method="post">
             <input type="hidden" name="id" value="${user.id!}"><br/>
            name: <input type="text" name="name" value="${user.name!}"><br/>
            age: <input type="text" name="age" value="${user.age!}"><br/>
            birthday: <input type="text" name="birthday" value="${user.birthday!}"><br/>
            address: <input type="text" name="address" value="${user.address!}"><br/>
            phone: <input type="text" name="phone" value="${user.phone!}"><br/>
            <input type="submit">
        </form>
    </body>
</html>