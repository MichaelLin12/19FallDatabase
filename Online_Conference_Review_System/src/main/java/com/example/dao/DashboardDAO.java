package com.example.dao;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.entity.CompanyMapper;
import com.example.entity.Dashboard;
import com.example.entity.Employee;


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
