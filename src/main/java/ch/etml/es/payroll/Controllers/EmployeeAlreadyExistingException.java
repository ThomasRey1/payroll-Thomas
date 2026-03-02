package ch.etml.es.payroll.Controllers;

import ch.etml.es.payroll.Entities.Employee;

public class EmployeeAlreadyExistingException extends RuntimeException {
    public EmployeeAlreadyExistingException(Employee employee) {
        super("Employee "+ employee.getName() + " already exists");
    }
}
