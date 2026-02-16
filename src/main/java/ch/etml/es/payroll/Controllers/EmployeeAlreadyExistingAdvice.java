package ch.etml.es.payroll.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeAlreadyExistingAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeAlreadyExistingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String employeeAlreadyExistingHandler(EmployeeAlreadyExistingException ex){
        return ex.getMessage();
    }
}
