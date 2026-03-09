package ch.etml.es.payroll.services;

import ch.etml.es.payroll.controllers.DepartmentAlreadyExistsException;
import ch.etml.es.payroll.entities.Department;
import ch.etml.es.payroll.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private static DepartmentRepository repository = null;

    public DepartmentService(DepartmentRepository repository){
        DepartmentService.repository = repository;
    }

    public static Department create(Department newDepartment){
        Department existing = repository.findByAcronym(newDepartment.getAcronym()).orElse(null);
        if(existing != null)
            throw new DepartmentAlreadyExistsException(newDepartment);
        return repository.save(newDepartment);
    }
}
