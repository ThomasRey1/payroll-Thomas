package ch.etml.es.payroll.controllers;

import ch.etml.es.payroll.entities.Employee;

public class EmployeeAlreadyExistingException extends RuntimeException {
    public EmployeeAlreadyExistingException(Employee employee) {
        super("Employee "+ employee.getName() + " already exists");
    }
}
