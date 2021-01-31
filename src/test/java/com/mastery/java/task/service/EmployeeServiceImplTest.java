package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Throwable throwable;

    float averageAge = 0;

    @Test
    public void showAverageAge_unhappyPath() {
        //Given

        List<Employee> employees = new ArrayList<>();
        when(employeeDao.findAll()).thenReturn(employees);

        //When
        throwable = catchThrowable(() -> averageAge = employeeService.calculateAverageAge());

        //Then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void showAverageAge_happyPath() {
        //Given

        List<Employee> employees = generateEmployees();
        when(employeeDao.findAll()).thenReturn(employees);

        //When
        throwable = catchThrowable(() -> averageAge = employeeService.calculateAverageAge());

        //Then
        assertThat(throwable, is(nullValue()));
        Assertions.assertThat(averageAge).isEqualTo(31.0f);

    }

    private List<Employee> generateEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ann", "Derechennik", 1, "Engineer", Gender.FEMALE, "18-04-1983"));
        employees.add(new Employee("Vita", "Razumeichyk", 1, "Programmer", Gender.FEMALE, "29-05-1981"));
        employees.add(new Employee("Mikl", "Ivanov", 2, "Engineer", Gender.MALE, "18-01-1995"));
        employees.add(new Employee("Vladislav", "Petrov", 2, "Programmer", Gender.MALE, "18-01-1999"));
        return employees;
    }
}









