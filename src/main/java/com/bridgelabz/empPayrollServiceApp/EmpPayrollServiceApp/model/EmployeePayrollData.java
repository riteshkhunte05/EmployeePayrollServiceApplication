package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto.EmployeePayrollDTO;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Data.
 * @author Ritesh
 **********************************************************************************************************************/
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name ="Id"))
    @Column(name = "departments")
    private List<String> departments;

    public EmployeePayrollData(){}

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayollData(employeePayrollDTO);
    }

    public void updateEmployeePayollData( EmployeePayrollDTO employeePayrollDTO) {

        this.employeeId=employeeId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }
}