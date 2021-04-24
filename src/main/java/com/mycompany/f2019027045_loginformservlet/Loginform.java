package com.mycompany.f2019027045_loginformservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arslan Shabbir
 */
public class Loginform extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (Validate.checkUser(email, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        } 
        else 
        {
            out.println("Invalid UserName or Password");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
    }
}
