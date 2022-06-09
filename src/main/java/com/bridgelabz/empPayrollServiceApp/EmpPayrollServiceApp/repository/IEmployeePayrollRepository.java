package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.repository;

import com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query(value = "select * from employee_payroll,employee_department where emp_id=id and departments=:department", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

    @Query(value = "select * from employee_payroll where salary = :salary", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesBySalary(long salary);

    @Query(value = "select * from employee_payroll where gender = :gender", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByGender(String gender);

    @Query(value = "select * from employee_payroll where startDate = :startDate", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByStartDate(LocalDate startDate);

}

