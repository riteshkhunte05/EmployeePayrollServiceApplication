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
        return empDataList;
    }

    /**
     * Method :- Method to Get  Employee Payroll Data By Id.
     *
     * @param empId :- Passing empId As Input.
     * @return Returning Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return  empDataList.stream()
                .filter(empData->empData.getEmployeeId()==empId)
                .findFirst()
                .orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
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
        empDataList.add(empData);
        log.debug("Emp Data: " +empData.toString());
        empDataList.add(empData);
        return employeePayrollRepository.save(empData);
    }

    /**
     * Method :- Method to Update Employee Payroll Data.
     * @param empId :- Passing empId As Input.
     * @param employeePayrollDTO :- Passing employeePayrollDTO As Input.
     * @return Returning updated Employee Payroll Data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        empDataList.set(empId - 1, empData);
        return empData;
    }

    /** Method :- Method to Delete Employee Payroll Data.
     *
     * @param empId :- Passing empId As Input.
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {

        empDataList.remove(empId - 1);
    }
}