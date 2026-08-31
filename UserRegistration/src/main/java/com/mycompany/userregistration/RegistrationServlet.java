package com.mycompany.userregistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
    public static final Map<String, String> user = new HashMap<>();
    
    public static final Map<String, String> roles = new HashMap<>();
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            
            throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(username == null || username.trim().isEmpty()|| password == null || password.trim().isEmpty()|| role == null || role.trim().isEmpty() ){
            out.println("Registration has failed");
            out.println("<p>Username, password, role are required. </p>");
            return;
        }
        
        if(user.containsKey(username)) {
            out.println("Registration failed");
            out.println("username already exist.");
            return;
        }
        user.put(username, password);
        roles.put(username,role);
        
        out.println("Registration successful");
        
    }
}
