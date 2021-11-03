package refactor.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import refactor.MainHandler;

@WebServlet("HomeController")
public class HomeController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");  

        String name = request.getParameter("name");  
        String mail = request.getParameter("mail");

        MainHandler.getHandler().registerUser(name, "password", "nickName", mail);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
        rd.forward(request, response);  
    }

    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}