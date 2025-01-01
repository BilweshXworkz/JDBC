package com.xworkz.companyapp.doa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeptDoa {
    private int deptId;
    private String deptName;
    private String managerName;
    private String location;
    private long phoneNo;
    private int budget;
}
