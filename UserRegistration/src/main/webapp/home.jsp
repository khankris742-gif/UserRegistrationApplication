
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String username = (String) session.getAttribute("username"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
    </head>
    <body>
        <h2>Welcome </h2>
        <p><%= username != null? username : "Guest" %>!</p>
        
        <h3>Notifications</h3>
        <div id="notifications">
            <p>No new notifications.</p>
        </div>
    </body>
</html>
