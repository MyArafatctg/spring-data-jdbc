package com.arafat.spring_data_jdbc.spring_data_jdbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String designation;
    private LocalDate joinDate;
}
