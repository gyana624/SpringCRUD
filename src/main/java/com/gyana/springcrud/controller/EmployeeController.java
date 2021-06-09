package com.gyana.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyana.springcrud.entity.Employee;
import com.gyana.springcrud.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterfacce;

	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employeeSaved = employeeServiceInterfacce.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> listOfAllEMployee = employeeServiceInterfacce.getAllEmployee();
		return new ResponseEntity<List<Employee>>(listOfAllEMployee, HttpStatus.OK);
	}

	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long empId) {
		Employee empRetrieved = employeeServiceInterfacce.getEmployeeById(empId);
		return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empId") Long empId) {
		employeeServiceInterfacce.deleteEmployeeById(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee employeeSaved = employeeServiceInterfacce.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		
	}
	@GetMapping("/user")
	public String welcomeMsg() {
		
		return "Welcome to USER";
	}

}

//}
//@Autowired
//EmployeeRepo employeeRopo;

//@GetMapping 
//public List<Employee> getAllEmployee(){
//	System.out.println("Getting all the employee");
//	return employeeRopo.findAll();
//}
