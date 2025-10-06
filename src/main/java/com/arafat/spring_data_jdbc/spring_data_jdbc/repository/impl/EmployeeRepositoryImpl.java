package com.arafat.spring_data_jdbc.spring_data_jdbc.repository.impl;

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
    public Employee save(Employee employee) {
        String  sql = "insert into employee (name, designation, join_date) values (?, ?, ?)";
        int id = jdbcTemplate.update(sql, employee.getName(), employee.getDesignation(), employee.getJoinDate());
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}
