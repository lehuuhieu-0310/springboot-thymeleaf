package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.EmployeeRepository;
import com.example.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(String theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee employee = null;
		
		if(result.isPresent()) {   //return 'false' if 'result' is empty
			employee = result.get();
		}
		return employee;
	}


	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}


	@Override
	public void deleteById(String theId) {
		
		employeeRepository.deleteById(theId);
		
	}

	
}
