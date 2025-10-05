package com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class EmpRequest {
    private String name;
    private String designation;
    private LocalDate joinDate;
}
