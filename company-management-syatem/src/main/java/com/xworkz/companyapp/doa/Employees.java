package com.xworkz.companyapp.doa;

import java.sql.ResultSet;

public interface Employees {
    public boolean addEmp( String empName, int empAge, String jobTitle, int salary, int deptId);
    public ResultSet getEmpDetails();
    public int getUpdateEmpById(String empName, int empAge, int empId);
}
