package ch.etml.es.payroll.Controllers;

public class DepartmentAlreadyExistsException extends RuntimeException {
  public DepartmentAlreadyExistsException(String message) {
    super(message);
  }
}
