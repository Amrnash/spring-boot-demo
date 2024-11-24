package com.sololeveler.cruddemo.dao;
import com.sololeveler.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int employeeId);
}
