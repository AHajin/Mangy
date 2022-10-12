package com.tubyapp.tuby.Employee;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getEmployees(){
        return List.of(new Employee(
                1L,
                "George",
                LocalDate.of(1991, Month.FEBRUARY,21),
                30,
                "Web Developer"
        ));
    }

}
