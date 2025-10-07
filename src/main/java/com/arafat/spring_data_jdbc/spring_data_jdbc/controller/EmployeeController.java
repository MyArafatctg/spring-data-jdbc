package com.arafat.spring_data_jdbc.spring_data_jdbc.controller;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.requestDto.EmpRequest;
import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.responseDto.EmpResponse;
import com.arafat.spring_data_jdbc.spring_data_jdbc.mappers.EmployeeMapper;
import com.arafat.spring_data_jdbc.spring_data_jdbc.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/emp")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmpResponse>> getEmployee() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpResponse> getEmployee(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpResponse> createEmployee(@RequestBody EmpRequest empRequest) {
        var employee = employeeService.createEmployee(empRequest);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpResponse> updateEmployee(
           @RequestBody EmpRequest empRequest,
           @PathVariable int id) {
        var employee = employeeService.updateEmployee(employeeMapper.toEntity(empRequest, id), id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
