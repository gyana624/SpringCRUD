package com.gyana.springcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gyana.springcrud.entity.Employee;

@Service
public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	

	public List<Employee> getAllEmployee();



	public Employee getEmployeeById(Long empId);



	public void deleteEmployeeById(Long empId);

	
	

}
