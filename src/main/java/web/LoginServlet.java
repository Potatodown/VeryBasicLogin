package web;

import bean.Employee;
import dao.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet{
    private EmployeeDao empDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        boolean successfulLogin = false;
        Employee employee = new Employee();
        employee.setUserName(userName);
        employee.setPassword(password);

        try {
           successfulLogin = empDao.LoginEmployee(employee.getUserName(), employee.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (successfulLogin){
            request.setAttribute("Name", employee.getUserName());
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error","Login Failed");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
