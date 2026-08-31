

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>User Login</h2>
        <form action="login" method="post">
            <label>Username</label><!-- comment -->
            <input type = "text" name="username" required><!-- comment -->
            
            <br><br><!-- comment -->
            
             <label>Password</label><!-- comment -->
            <input type = "password" name="password" required><!-- comment -->
            
            <input type="submit" value="Login">
            
        </form>
        
        <br><!-- comment -->
        <a href="registration.jsp">Register</a>
    </body>
</html>
