package dao;

import bean.Employee;

import java.sql.*;

public class EmployeeDao {
    public int registerEmployee (Employee emp) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
                "(id, userName, password, firstName, lastName, emailAddress, hireDate) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmanager", "root", "Windows1");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, emp.getUserName());
            preparedStatement.setString(3, emp.getPassword());
            preparedStatement.setString(4, emp.getFirstName());
            preparedStatement.setString(5, emp.getLastName());
            preparedStatement.setString(6, emp.getEmailAddress());
            preparedStatement.setDate(7, Date.valueOf(emp.getHireDate()));

            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public boolean LoginEmployee(String userName, String password) throws ClassNotFoundException{
        boolean CorrectCredentials = false;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmanager", "root", "Windows1")){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT password FROM employee WHERE userName = '"+userName+"'");
            while (rs.next()) {
                String dbPassword = rs.getString("password");
                System.out.println(dbPassword + "\n");
                if(dbPassword.equals(password)){
                    CorrectCredentials = true;
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return CorrectCredentials;
    }
}
