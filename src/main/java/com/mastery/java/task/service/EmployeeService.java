package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteEmployee(long id);

    List<Employee> findAllByFirstName(String firstName);

    float calculateAverageAge();
}
