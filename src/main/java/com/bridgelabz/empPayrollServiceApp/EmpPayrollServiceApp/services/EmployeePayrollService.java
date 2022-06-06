package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.services;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto.EmployeePayrollDTO;
import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.exceptions.EmployeePayrollException;
import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model.EmployeePayrollData;
import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.repository.IEmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************************
 * Class :- Employee Payroll Service Class .
 * @author Ritesh

 **********************************************************************************************************************/
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private IEmployeePayrollRepository employeePayrollRepository;
    private List<EmployeePayrollData> empDataList = new ArrayList<>();



    /**
     * Method :- Method to Get All Employee Payroll Data.
     *
     * @return Returning Employee Payroll List.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    /**
     * Method :- Method to Get  Employee Payroll Data By Id.
     *
     * @param empId :- Passing empId As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmpId" + empId
                        + " Doesn't Exists...!"));
    }



    /**
     * Method :- Method to Create Employee Payroll Data.
     *
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Employee Data: " + empData.toString());
        return employeePayrollRepository.save(empData);
    }

    /**
     * Method :- Method to Update Employee Payroll Data.
     * @param empId :- Passing empId As Input.
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning updated Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    /** Method :- Method to Delete Employee Payroll Data.
     *
     * @param empId :- Passing empId As Input.
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
}