package com.arafat.spring_data_jdbc.spring_data_jdbc.services.impl;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.requestDto.EmpRequest;
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
    public EmpResponse createEmployee(EmpRequest request) {
        var employee = employeeRepository.save(request);
        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmpResponse updateEmployee(Employee employee, int id) {
        return employeeMapper.toResponse(employeeRepository.update(employee, id));
    }

    @Override
    public String deleteEmployee(int id) {
        return employeeRepository.deleteById(id);
    }
}
