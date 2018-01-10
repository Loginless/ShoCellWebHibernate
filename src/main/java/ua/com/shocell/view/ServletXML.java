package ua.com.shocell.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletXML")
public class ServletXML extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from XML Servlet");
        String userName = request.getParameter("userName");
        response.getWriter().print("Hello from Get method XML Servlet - on the webpage " + userName);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from XML Servlet");
        String userName = request.getParameter("userName");
        response.getWriter().print("Hello from Post method XML Servlet - on the webpage " + userName);
    }
}
