package com.xworkz.companyapp.doa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmpDoa {
    private int empId;
    private String empName;
    private int empAge;
    private String jobTitle;
    private int salary;
    private int deptId;
}
