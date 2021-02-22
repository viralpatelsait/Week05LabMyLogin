/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 834171
 */
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        if(logout!=null){
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Logout done");
        }
        
        if(session.getAttribute("username") != null){
         response.sendRedirect("home");
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(username == null||username.equals("")||password== null || password.equals("")){
            request.setAttribute("message", "Enter usernmae and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            }
            AccountService accService = new AccountService();
            User login = accService.login(username, password);
            
            if(login == null){
            request.setAttribute("message", "Invalid username and password");
            session.setAttribute("username", username);
            session.setAttribute("password", null);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            else{
            session.setAttribute("username", username);
            response.sendRedirect("home");
            }
    }

}
