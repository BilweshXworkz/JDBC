package com.xworkz.companyapp;

import com.xworkz.companyapp.doa.DepAndEmpImpl;
import com.xworkz.companyapp.doa.DeptDoa;
import com.xworkz.companyapp.doa.EmpDoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CompanyRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DepAndEmpImpl depAndEmp = new DepAndEmpImpl();
        System.out.println("Choose :");
        String val = null;
        do {
            System.out.println("1 Dept Details Entering");
            System.out.println("2 Dept Details");
            System.out.println("3 Update Dept");
            System.out.println("4 Get By number of DeptId AND Budget");
            System.out.println("5 Get By number of DeptId OR Budget");
            System.out.println("6 Emp Details Entering");
            System.out.println("7 Actors Emp");
            System.out.println("8 Update Emp");

            int option = scanner.nextInt();

            switch (option){
                case 1 :
                    DeptDoa dept = new DeptDoa();
                    System.out.println("Enter the Dept Name : ");
                    dept.setDeptName(scanner.next());
                    System.out.println("Enter Dept Manager name : ");
                    dept.setManagerName(scanner.next());
                    System.out.println("Enter the Location : ");
                    dept.setLocation(scanner.next());
                    System.out.println("Enter the Dept Phone No : ");
                    dept.setPhoneNo(scanner.nextLong());
                    System.out.println("Budget :");
                    dept.setBudget(scanner.nextInt());
                    depAndEmp.addDept(
                            dept.getDeptName(),
                            dept.getManagerName(),
                            dept.getLocation(),
                            dept.getPhoneNo(),
                            dept.getBudget()
                    );
                    break;
                case 2:
                    ResultSet resultSet = depAndEmp.getDeptDetails();
                    try{
                        boolean checkData =resultSet.next();
                        if (checkData){
                            while (resultSet.next()){
                                System.out.println("Dept ID : "+resultSet.getInt(1)+", " +
                                        "Dept Name : "+resultSet.getString(2)+", "+
                                        "Manager Name : "+resultSet.getString(3)+", "+
                                        "Location : "+resultSet.getString(4)+", "+
                                        "PhoneNo : "+resultSet.getLong(5)+", "+
                                        "Budget : "+resultSet.getInt(6));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter the DeptId to be updated Budget : ");
                    int  deptId = scanner.nextInt();
                    System.out.println("Enter the Dept Name : ");
                    String deptName = scanner.next();
                    System.out.println("Enter the Budget");
                    int budget = scanner.nextInt();
                    int updateById = depAndEmp.getUpdateDeptById(deptName, budget, deptId);
                    System.out.println("Number of rows affected "+updateById);
                    break;
                case 4:
                    System.out.println("Enter the Dept Id ");
                    int deptId1 = scanner.nextInt();
                    System.out.println("Enter Budget");
                    int budget1 = scanner.nextInt();
                    ResultSet resultSet1 = depAndEmp.getByDeptIdANDBudget(deptId1, budget1);
                    try{
                        boolean checkData = false;
                        while (resultSet1 != null && resultSet1.next()){
                            checkData = true;
                            System.out.println("Dept ID : "+resultSet1.getInt(1)+", " +
                                    "Dept Name : "+resultSet1.getString(2)+", "+
                                    "Manager Name : "+resultSet1.getString(3)+", "+
                                    "Location : "+resultSet1.getString(4)+", "+
                                    "PhoneNo : "+resultSet1.getLong(5)+", "+
                                    "Budget : "+resultSet1.getInt(6));
                        }
                        if (!checkData){
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the release year");
                    int releaseYear2 = scanner.nextInt();
                    System.out.println("Enter Rating");
                    int rating2 = scanner.nextInt();
                    ResultSet resultSet2 = depAndEmp.getByDeptIdORBudget(releaseYear2, rating2);
                    try {
                        boolean checkData = false;
                        while (resultSet2 != null && resultSet2.next()) {
                            checkData = true;
                            System.out.println("Dept ID : "+resultSet2.getInt(1)+", " +
                                    "Dept Name : "+resultSet2.getString(2)+", "+
                                    "Manager Name : "+resultSet2.getString(3)+", "+
                                    "Location : "+resultSet2.getString(4)+", "+
                                    "PhoneNo : "+resultSet2.getLong(5)+", "+
                                    "Budget : "+resultSet2.getInt(6));
                        }
                        if (!checkData) {
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    EmpDoa empDoa  = new EmpDoa();
                    System.out.println("Enter the Emp Name : ");
                    empDoa.setEmpName(scanner.next());
                    System.out.println("Enter Emp age : ");
                    empDoa.setEmpAge(scanner.nextInt());
                    System.out.println("Enter Job Title");
                    empDoa.setJobTitle(scanner.next());
                    System.out.println("Enter Salary");
                    empDoa.setSalary(scanner.nextInt());
                    System.out.println("Enter Dept Id");
                    empDoa.setDeptId(scanner.nextInt());
                    depAndEmp.addEmp(
                            empDoa.getEmpName(),
                            empDoa.getEmpAge(),
                            empDoa.getJobTitle(),
                            empDoa.getSalary(),
                            empDoa.getDeptId()
                    );
                case 7:
                    ResultSet resultSet3 = depAndEmp.getEmpDetails();
                    try{
                        boolean checkData =resultSet3.next();
                        if (checkData){
                            while (resultSet3.next()){
                                System.out.println("Emp ID : "+resultSet3.getInt(1)+", " +
                                        "Emp Name : "+resultSet3.getString(2)+", "+
                                        "Emp Age : "+resultSet3.getInt(3)+", "+
                                        "Salary : "+resultSet3.getString(4)+","+
                                        "Job Title :"+resultSet3.getString(5)+","+
                                        "Dept Id : "+resultSet3.getInt(6));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter the updated Emp By Id : ");
                    int  empId = scanner.nextInt();
                    System.out.println("Enter the Emp name : ");
                    String empName = scanner.next();
                    System.out.println("Enter the Emp age : ");
                    int empAge = scanner.nextInt();
                    int updateByPlayerId = depAndEmp.getUpdateEmpById(empName, empAge, empId);
                    System.out.println("Number of rows affected "+updateByPlayerId);
                    break;
                default:
                    System.out.println("Please Enter the valid number");
            }
            System.out.println("Do you want to continue? (Type Yes or No)");
            val = scanner.next();
        }
        while(val.equalsIgnoreCase("Yes"));
        System.out.println("Thank You for Your Co-operation... ");
    }
}
