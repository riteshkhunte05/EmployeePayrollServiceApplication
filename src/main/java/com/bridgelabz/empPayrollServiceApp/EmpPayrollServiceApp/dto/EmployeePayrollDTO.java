package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * Employee Payroll DTO class.
 */
@Data
public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    @NotEmpty(message = "Employee name can't be null")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;
    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;
    public String gender;
    public String note;
    public String profilePic;
    public List<String> departments;

}