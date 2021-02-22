<%-- 
    Document   : login
    Created on : Feb 21, 2021, 7:33:49 AM
    Author     : 834171
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <p>Username:<input type="text" name="username" value="${username}"></p>
            <p>Password:<input type="password" name="password" value="${password}"></p>
            <p>${message}</p>
            <input type="submit" value="Login">
            
        </form>
    </body>
</html>
