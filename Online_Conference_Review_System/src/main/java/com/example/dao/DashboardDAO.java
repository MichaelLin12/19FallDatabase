package com.example.dao;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.domain.CompanyMapper;
import com.example.demo.domain.Dashboard;
import com.example.demo.domain.Employee;


@Component
public class DashboardDAO {
	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Dashboard> getdashboardList() {
		
		List<Dashboard> paperList = new ArrayList<Dashboard>();
		
		paperList = companyMapper.getPaperList();
		
		return paperList;
	}
	
}
