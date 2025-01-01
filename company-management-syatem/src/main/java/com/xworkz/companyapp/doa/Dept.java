package com.xworkz.companyapp.doa;

import java.sql.ResultSet;

public interface Dept {
    public boolean addDept(String deptName, String managerName, String location, long phoneNo, int budget);
    public ResultSet getDeptDetails();
    public int getUpdateDeptById(String deptName, int budget, int deptId);
    public ResultSet getByDeptIdANDBudget(int deptId, int budget);
    public ResultSet getByDeptIdORBudget(int deptId, int budget);
}
