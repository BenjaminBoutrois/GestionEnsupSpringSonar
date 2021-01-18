package eu.ensup.partiel_spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partiel_spring.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
