package com.scaspb.db_boot.dao;

import com.scaspb.db_boot.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployees(int id);

    public void deleteEmployee(int id);
}
