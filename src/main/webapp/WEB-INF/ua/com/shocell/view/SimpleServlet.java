package ua.com.shocell.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "Simple Servlet", name = "SimpleServlet", urlPatterns = "/Simpleservlet")
public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from Simple Servlet");
        response.getWriter().print("Hello from Simple Servlet - on the webpage");
    }
}
