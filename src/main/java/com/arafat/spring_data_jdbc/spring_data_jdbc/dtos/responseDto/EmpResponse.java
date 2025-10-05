package com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmpResponse {
    private int id;
    private String name;
    private String designation;
    private LocalDate joinDate;
}
