package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.CompanyMapper;

@Component
public class EmployeeDAO {
	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Employee> getEmpList() {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		empList = companyMapper.getEmpList();
		
		
		/*
		 * Employee e1 = new Employee("John", "Smith", "123456"); Employee e2 = new
		 * Employee("Sally", "jones", "234567"); Employee e3 = new Employee("Praveen",
		 * "M", "345678");
		 * 
		 * empList.add(e1); empList.add(e2); empList.add(e3);
		 */
		return empList;
	}

	public void createNewEmployee(Employee employee) {
		
		companyMapper.createNewEmployee(employee);
		
	}

}

