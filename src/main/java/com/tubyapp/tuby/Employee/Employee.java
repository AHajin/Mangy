package com.tubyapp.tuby.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private LocalDate DateOfBirth;
    @Transient
    private Integer Age;
    private String Company;
    private String Job;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(DateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public Employee(){

    }

    public Employee(Long id,
                    String name,
                    LocalDate dateOfBirth,
                    String company,
                    String job) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
        Company = company;
        Job = job;
    }

    public Employee(String name,
                    LocalDate dateOfBirth,
                    String company,
                    String job) {
        this.name = name;
        DateOfBirth = dateOfBirth;
        Company = company;
        Job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Age=" + Age +
                ", Company=" + Company +
                ", Job='" + Job + '\'' +
                '}';
    }
}
