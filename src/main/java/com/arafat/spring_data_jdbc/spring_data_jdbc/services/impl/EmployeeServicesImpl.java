package com.arafat.spring_data_jdbc.spring_data_jdbc.services.impl;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.responseDto.EmpResponse;
import com.arafat.spring_data_jdbc.spring_data_jdbc.entities.Employee;
import com.arafat.spring_data_jdbc.spring_data_jdbc.mappers.EmployeeMapper;
import com.arafat.spring_data_jdbc.spring_data_jdbc.repository.EmployeeRepository;
import com.arafat.spring_data_jdbc.spring_data_jdbc.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServicesImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public List<EmpResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    public EmpResponse findById(int id) {
        return employeeMapper.toResponse(employeeRepository.findById(id));
    }

    @Override
    public EmpResponse createEmployee(Employee employee) {
        var employe = employeeRepository.save(employee);
        return employeeMapper.toResponse(employe);
    }

    @Override
    public EmpResponse updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {

    }
}
