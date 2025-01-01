package com.xworkz.companyapp.doa;

import java.sql.*;

public class DepAndEmpImpl implements Employees, Dept{
    static private String url = "jdbc:mysql://localhost:3306/companyAndEmp";
    static private String user = "root";
    static private String pass = "bilwesh";
    @Override
    public boolean addDept(String deptName, String managerName, String location, long phoneNo, int budget) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            String query = "insert into Dept values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, deptName);
            statement.setString(3, managerName);
            statement.setString(4, location);
            statement.setLong(5, phoneNo);
            statement.setInt(6, budget);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return isAdded;
    }

    @Override
    public ResultSet getDeptDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM Dept";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int getUpdateDeptById(String deptName, int budget, int deptId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update Dept set deptName = ?, budget = ? where deptId = ?");
            connection.setAutoCommit(false);
            statement.setInt(1, deptId);
            statement.setString(2, deptName);
            statement.setInt(3, budget);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try{
                connection.rollback();
            }catch (SQLException error){
                System.out.println(error.getMessage());
            }
        }
        return 0;
    }

    @Override
    public ResultSet getByDeptIdANDBudget(int deptId, int budget) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user,pass);
            String query = "SELECT * FROM Dept WHERE deptId < ? AND budget >= ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, deptId);
            statement.setInt(2, budget);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByDeptIdORBudget(int deptId, int budget) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM Dept WHERE deptId > ? OR budget <=";
            statement.setInt(1, deptId);
            statement.setInt(2, budget);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addEmp(String empName, int empAge, String jobTitle, int salary, int deptId) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database is connected");
            String query = "insert into Emp values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, empName);
            statement.setInt(3,empAge);
            statement.setString(4, jobTitle);
            statement.setInt(5, salary);
            statement.setInt(6,deptId);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException |SQLException e){
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public ResultSet getEmpDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM Emp";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int getUpdateEmpById(String empName, int empAge, int empId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update Emp set empName = ?, empAge = ? where empId = ?");
            connection.setAutoCommit(false);
            statement.setString(1, empName);
            statement.setInt(2, empAge);
            statement.setInt(3, empId);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try{
                connection.rollback();
            }catch (SQLException error){
                System.out.println(error.getMessage());
            }
        }
        return 0;
    }
}
