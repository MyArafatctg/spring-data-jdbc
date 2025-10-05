package com.arafat.spring_data_jdbc.spring_data_jdbc.services;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.responseDto.EmpResponse;
import com.arafat.spring_data_jdbc.spring_data_jdbc.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<EmpResponse> findAll();
    public List<EmpResponse> findById(int id);
    public EmpResponse createEmployee(Employee employee);
    public EmpResponse updateEmployee(Employee employee);
    public void deleteEmployee(int id);
}
