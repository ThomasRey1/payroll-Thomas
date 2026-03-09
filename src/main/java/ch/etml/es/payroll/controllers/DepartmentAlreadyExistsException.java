package ch.etml.es.payroll.controllers;

import ch.etml.es.payroll.entities.Department;

public class DepartmentAlreadyExistsException extends RuntimeException {
    public DepartmentAlreadyExistsException(Department department) {
        super("Department "+ department.getAcronym() + " already exists");
    }
}
