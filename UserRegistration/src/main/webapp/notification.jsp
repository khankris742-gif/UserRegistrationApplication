<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");
    if (username == null){
        response.sendRedirect("login.jsp");
        return;
    }
    if(!"Church Leader".equals(role)){
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
        return;
    }


%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifications</title>
    </head>
    <body>
        <h2>Church Leader notification page</h2>
        <p> <%= username%> </p>
        
        <h3>Send notification</h3>
        <form>
            <textarea rows="8" cols="30" placeholder="Enter notification"></textarea>
            <br><br><!-- comment -->
            <input type="submit" value="Send notification">
        </form>
        
    </body>
</html>
