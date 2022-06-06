package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.repository;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

}
