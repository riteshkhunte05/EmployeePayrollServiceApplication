/**
 * ResponseDTO class.
 */
package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}