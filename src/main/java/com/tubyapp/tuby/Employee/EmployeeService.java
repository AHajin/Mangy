package com.tubyapp.tuby.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByName(employee.getName());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new IllegalStateException("employee with id "+ employeeId + " does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String name, String job, String company) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new IllegalStateException("employee with id "+ employeeId + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(),name)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByName(name);
            if(employeeOptional.isPresent()){throw new IllegalStateException("name taken");}
            employee.setName(name);
        }
        if (job != null && job.length() > 0 && !Objects.equals(employee.getJob(),job)){
            employee.setJob(job);
        }
        if (company != null && company.length() > 0 && !Objects.equals(employee.getCompany(),company)){

            employee.setCompany(company);
        }

    }
}
