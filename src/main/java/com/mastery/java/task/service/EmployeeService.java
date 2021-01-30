package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(long id);

    public void deleteEmployee(long id);

    public List<Employee> findAllByFirstName(String firstName);
}
