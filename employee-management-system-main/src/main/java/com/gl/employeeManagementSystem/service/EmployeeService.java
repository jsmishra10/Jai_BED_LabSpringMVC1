package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(Long id);

	public void saveEmployee(Employee employee);

	public Employee updateEmployee(Long id, Employee employee);

	public void deleteEmployeeById(Long id);

}
