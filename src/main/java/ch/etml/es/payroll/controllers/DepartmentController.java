package ch.etml.es.payroll.controllers;

import ch.etml.es.payroll.entities.Department;
import ch.etml.es.payroll.repositories.DepartmentRepository;
import ch.etml.es.payroll.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository){
        this.repository = repository;
    }

    /* curl sample :
    curl -i -X GET localhost:8080/api/v1/departments | jq
     */
    @GetMapping("")
    List<Department> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -i -X GET localhost:8080/api/v1/departments/1
     */
    @GetMapping("/{id}")
    Department one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    /* curl sample :
    curl -i -X POST localhost:8080/api/v1/departments -H "Content-Type: application/json" -d "{\"acronym\": \"MKT\", \"description\": \"Marketing\"}"
     */
    @PostMapping("")
    ResponseEntity<Department> newDepartment(@RequestBody Department newDepartment){
        Department createdDepartment = DepartmentService.create(newDepartment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDepartment.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdDepartment);
    }
}
