package com.tubyapp.tuby.Employee;

import java.time.LocalDate;

public class Employee {
    private Long id;
    private String name;
    private LocalDate DateOfBirth;
    private Integer Age;
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
        return Age;
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
                    Integer age,
                    String job) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
        Age = age;
        Job = job;
    }

    public Employee(String name,
                    LocalDate dateOfBirth,
                    Integer age,
                    String job) {
        this.name = name;
        DateOfBirth = dateOfBirth;
        Age = age;
        Job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Age=" + Age +
                ", Job='" + Job + '\'' +
                '}';
    }
}
