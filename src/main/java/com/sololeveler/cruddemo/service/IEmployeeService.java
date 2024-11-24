package com.sololeveler.cruddemo.service;
import com.sololeveler.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int employeeId);
}
