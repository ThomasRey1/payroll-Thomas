package ch.etml.es.payroll.Controllers;

public class DepartmentNotFoundException extends RuntimeException {
  public DepartmentNotFoundException(String message) {
    super(message);
  }
}
