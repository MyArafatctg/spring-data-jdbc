package com.arafat.spring_data_jdbc.spring_data_jdbc.repository.impl;

import com.arafat.spring_data_jdbc.spring_data_jdbc.dtos.requestDto.EmpRequest;
import com.arafat.spring_data_jdbc.spring_data_jdbc.entities.Employee;
import com.arafat.spring_data_jdbc.spring_data_jdbc.mappers.EmployeeMapper;
import com.arafat.spring_data_jdbc.spring_data_jdbc.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        var joinDate = rs.getDate("join_Date");
        return new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("designation"),
                joinDate == null ? null : joinDate.toLocalDate()
        );
    };



    @Override
    public List<Employee> findAll() {
        String  sql = "select * from employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id = ?", rowMapper, id);
    }

    @Override
    public Employee save(EmpRequest employee) {
        String  sql = "insert into employee (name, designation, join_date) values (?, ?, ?)";
        int id = jdbcTemplate.update(sql, employee.getName(), employee.getDesignation(), employee.getJoinDate());
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public String deleteById(int id) {
        Employee employee = findById(id);
        if (employee != null) {
            String  sql = "delete from employee where id = ?";
            jdbcTemplate.update(sql, id);
            return "Employee " + employee.getId() + " has been deleted";
        }
        return "Employee with id " + id + " does not exist";
    }

    @Override
    public Employee update(Employee employee, int id) {
        Employee updatedEmp = findById(id);
        if (updatedEmp == null) {
            throw new RuntimeException("Employee with id " + id + " does not exist");
        }
        String sql = "update employee set name = ?, designation = ?, join_date = ?  where id = ?";
        updatedEmp.setName(employee.getName());
        updatedEmp.setDesignation(employee.getDesignation());
        updatedEmp.setJoinDate(employee.getJoinDate());
        jdbcTemplate.update(sql, employee.getName(), employee.getDesignation(), employee.getJoinDate(), id);
        return updatedEmp;
    }
}
