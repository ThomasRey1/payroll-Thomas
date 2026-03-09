package ch.etml.es.payroll.repositories;

import ch.etml.es.payroll.entities.Department;
import ch.etml.es.payroll.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, DepartmentRepository departmentRepository){
        return args->{
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
            log.info("Preloading " + departmentRepository.save(new Department("MKT", "Marketing")));
            log.info("Preloading " + departmentRepository.save(new Department("SAS", "Sales")));
        };
    }
}
