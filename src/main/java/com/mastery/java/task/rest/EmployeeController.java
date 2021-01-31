package com.mastery.java.task.rest;


import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        // if (employee==null){
        //     throw new NoSuchEmployeeException("There is no employee with ID="+employeeId
        //     +" in Database");
        // }
        return employee;
    }

    @PostMapping("/employees")
    public void addNewEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeeByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByFirstName(name);
        return employees;
    }

    @GetMapping("/employees/average-age")
    public float calculateAverageAge() {
        return employeeService.calculateAverageAge();
    }

}
