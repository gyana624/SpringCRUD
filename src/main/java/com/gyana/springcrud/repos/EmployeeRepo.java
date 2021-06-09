package com.gyana.springcrud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gyana.springcrud.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	

}
