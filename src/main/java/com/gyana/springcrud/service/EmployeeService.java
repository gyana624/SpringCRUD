package com.gyana.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyana.springcrud.custom.exception.BusinessException;
import com.gyana.springcrud.entity.Employee;
import com.gyana.springcrud.repos.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			if (employee.getName().isEmpty() || employee.getName().length() == 0) {
				throw new BusinessException("601", "Please send proper name,its blank");
			}
			Employee savedEmployee = employeeRepo.save(employee);
			return savedEmployee;

		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given employee is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service layer" + e.getMessage());
		}

	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();

	}

	@Override
	public Employee getEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(empId).get();
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(empId);

	}

}
