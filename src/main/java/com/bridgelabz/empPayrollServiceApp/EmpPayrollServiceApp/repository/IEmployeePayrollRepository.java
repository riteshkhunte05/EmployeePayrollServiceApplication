package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.repository;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query(value = "select * from employee_payroll,employee_department where emp_id=id and departments=:department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}

