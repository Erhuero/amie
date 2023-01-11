package com.mgen.amie.service;

import com.mgen.amie.entity.EmployeeEntity;
import com.mgen.amie.exception.BadRequestException;
import com.mgen.amie.model.Employee;
import com.mgen.amie.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        try {
            List<EmployeeEntity> employees = employeeRepository.findAll();
            List<Employee> customEmployees = new ArrayList<>();
            employees.stream().forEach(e -> {
                Employee employee = new Employee();
                BeanUtils.copyProperties(e, employee);
                customEmployees.add(employee);
            });
            return customEmployees;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addEmployee(EmployeeEntity employee) {
        try {
            if (!employeeRepository.existsByFirstNameAndLastName(
                    employee.getFirstName(),
                    employee.getLastName())) {
                employeeRepository.save(employee);
                return "Employé ajouté avec succés";
            } else {
                return "Cet employé est déjà dans la base de données";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsByFirstNameAndLastName(
                    employee.getFirstName(),
                    employee.getLastName())
                    || employeeRepository.existsById(employee.getId())) {
                employeeRepository.delete(employee);
                return "Employé supprimé avec succès";
            } else {
                return "Employé n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateEmployee(EmployeeEntity employee){
        try {
            if (employeeRepository.existsById(employee.getId())) {
                employeeRepository.save(employee);
                return "Employé mis à jour";
            } else {
                return "Employé n'existe pas";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}