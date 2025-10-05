package com.arafat.spring_data_jdbc.spring_data_jdbc.repository;

import com.arafat.spring_data_jdbc.spring_data_jdbc.entities.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
    public Employee update(Employee employee);
}
