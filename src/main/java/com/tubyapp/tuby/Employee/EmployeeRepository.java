package com.tubyapp.tuby.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //SELECT * FROM employee WHERE name = name
    @Query("SELECT employee FROM Employee employee WHERE employee.name = ?1")
    Optional<Employee> findEmployeeByName(String name);


}
