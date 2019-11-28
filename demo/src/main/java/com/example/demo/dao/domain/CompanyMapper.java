package com.example.demo.dao.domain;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Employee;

@Mapper
public interface CompanyMapper {
	
	@Select("SELECT FNAME,LNAME, SSN FROM EMPLOYEE")
	public List<Employee> getEmpList();

	@Insert("insert into employee(fname,lname,ssn,dno) values (#{fname}, #{lname}, #{ssn}, #{dno})")
	public void createNewEmployee(Employee employee);
	

}
