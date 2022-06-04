package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto.EmployeePayrollDTO;

import lombok.Data;

/***********************************************************************************************************************
 * Class :- Employee Payroll Data.
 * @author Ritesh
 **********************************************************************************************************************/
@Data
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(){}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
        this.employeeId=empId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
    }
}