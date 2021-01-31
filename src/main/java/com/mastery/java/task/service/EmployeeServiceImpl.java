package com.mastery.java.task.service;


import antlr.StringUtils;
import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        Employee employee = null;
        Optional<Employee> optional = employeeDao.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public float calculateAverageAge() {
        List<Employee> employees = employeeDao.findAll();
        int sum = 0;

        for (Employee employee : employees) {
            String[] birthday = employee.getDateOfBirth().split("-");
            int age = Period.between(LocalDate.of(Integer.parseInt(birthday[2]), Integer.parseInt(birthday[1]), Integer.parseInt(birthday[0])),
                    LocalDate.now()
            ).getYears();
            sum += age;
        }
        if (sum == 0) {
            throw new IllegalArgumentException("Unable to calculate average age");
        }
        return (float) sum / employees.size();

    }

    @Override
    public List<Employee> findAllByFirstName(String firstName) {
        return employeeDao.findAllByFirstName(firstName);
    }
}
