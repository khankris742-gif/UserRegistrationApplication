
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
        <h1>Registration</h1>
        <form action="register" method="post">
            <label>Username</label><!-- comment -->
            <input type = "text" name="username" required><!-- comment -->
            
            <br><br><!-- comment -->
            
             <label>Password</label><!-- comment -->
            <input type = "password" name="password" required><!-- comment -->
            
            <br><br><!-- comment -->
            <label>Role:</label>
            <select name="role">
                <option value="Member">Member</option>
                <option value="church leader">church leader</option>
            </select>
            
            <br><br> 
            
            <input type="submit" value="Register"><!-- comment -->
            
            <a href="login.jsp">Already have an account? Login</a>
        </form>
    </body>
</html>
