package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Employee;

public class EmployeeService {

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee e1 = new Employee("John", "Smith", "123456");
		Employee e2 = new Employee("Sally", "jones", "234567");
		Employee e3 = new Employee("Praveen", "M", "345678");
		
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		
		return empList;
		

	}

}
