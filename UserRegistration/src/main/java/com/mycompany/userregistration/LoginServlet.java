/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.userregistration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if (username == null || username.trim().isEmpty()|| password == null || password.trim().isEmpty()){
            out.println("Login failed");
            out.println("username and password required");
            return;
        }
        if(!RegistrationServlet.user.containsKey(username)){
            out.println("Login failed");
            out.println("Incorrect Username.");
            return;
        }
        
        String storedPassword = RegistrationServlet.user.get(username);
        
        if(!storedPassword.equals(password)){
            out.println("Login failed");
            out.println("Incorrect Password");
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        
        String role = RegistrationServlet.roles.get(username);
        session.setAttribute("role",role);
        
        out.println("Login Successful");
    }
}
        