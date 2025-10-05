package com.arafat.spring_data_jdbc.spring_data_jdbc.mappers;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.requestDto.EmpRequest;
import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.responseDto.EmpResponse;
import com.arafat.spring_data_jdbc.spring_data_jdbc.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmpResponse toResponse(Employee employee) {
        return  new EmpResponse(
                employee.getId(),
                employee.getName(),
                employee.getDesignation(),
                employee.getJoinDate()
        );
    } ;

    public Employee toEntity(EmpRequest empRequest, int id) {
        return  new Employee(
                id,
                empRequest.getName(),
                empRequest.getDesignation(),
                empRequest.getJoinDate()
        );
    }
}
