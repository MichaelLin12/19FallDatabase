package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.EmployeeDAO;
import com.example.demo.domain.Employee;

@Component
public class EmployeeService {

@Autowired
EmployeeDAO employeeDAO; 

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();
		
		//EmployeeDAO employeeDAO = new EmployeeDAO();
		
		empList = employeeDAO.getEmpList();
		
		
		return empList;
		

	}

	public void createNewEmployee(Employee employee) {
		
		employeeDAO.createNewEmployee(employee);
		
	}

}
