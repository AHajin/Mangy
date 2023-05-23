package com.tubyapp.tuby.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
           Employee george = new Employee(
                    "George",
                    LocalDate.of(1991, Month.FEBRUARY,21),
                    "google",
                    "Web Developer"
            );
            Employee paul = new Employee(
                    "Paul",
                    LocalDate.of(1987, Month.OCTOBER,14),
                    "amazon",
                    "FullStack Engineer"
            );
            repository.saveAll(List.of(paul,george));
        };
    }
}
