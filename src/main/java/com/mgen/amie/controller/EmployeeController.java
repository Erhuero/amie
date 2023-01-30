package com.mgen.amie.controller;


import com.mgen.amie.entity.EmployeeEntity;
import com.mgen.amie.model.Employee;
import com.mgen.amie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "getallemployees", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        //throw new IllegalStateException("Erreur d'éxecution !");
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "addemployee", method = RequestMethod.POST)
    public String addEmployee(@Valid @RequestBody EmployeeEntity employee){
        return employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "updateemployee", method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "removeemployee", method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.deleteEmployee(employee);
    }
}
