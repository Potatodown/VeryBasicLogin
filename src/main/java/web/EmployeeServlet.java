package web;

import bean.Employee;
import dao.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/signup")
public class EmployeeServlet extends HttpServlet{
    private EmployeeDao empDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String hireDate = request.getParameter("hireDate");
        Employee employee = new Employee();

        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmailAddress(emailAddress);
        employee.setHireDate(hireDate);

        try {
            empDao.registerEmployee(employee);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}