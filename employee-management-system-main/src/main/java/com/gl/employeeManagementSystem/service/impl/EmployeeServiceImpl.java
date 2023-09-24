package com.gl.employeeManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.repository.EmployeeRepository;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAllEmployees() {

		List<Employee> employeelist = employeeRepository.findAll();
		return employeelist;
	}

	@Override
	public Employee findEmployeeById(Long id) {

		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Not able to find the Employee " + id);
		}

		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {

		Optional<Employee> result = employeeRepository.findById(id);
		if (result.isPresent()) {
			employeeRepository.save(employee);
		}
		
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
