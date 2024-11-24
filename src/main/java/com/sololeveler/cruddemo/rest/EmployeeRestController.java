package com.sololeveler.cruddemo.rest;

import com.sololeveler.cruddemo.entity.Employee;
import com.sololeveler.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeID}")
    public  Employee getEmployee(@PathVariable int employeeID) {
        Employee employee = employeeService.findById(employeeID);

        if (employee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeID);
        }

        return employee;
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("")
    public Employee updatedEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
