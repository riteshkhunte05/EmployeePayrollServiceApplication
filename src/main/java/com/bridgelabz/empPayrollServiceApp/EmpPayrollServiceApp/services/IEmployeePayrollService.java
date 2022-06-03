package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.services;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto.EmployeePayrollDTO;
import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.List;

/***********************************************************************************************************************
 * Interface :- Interface for Employee Payroll Service.
 * @author Ritesh
 **********************************************************************************************************************/
@Service
public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();


    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}