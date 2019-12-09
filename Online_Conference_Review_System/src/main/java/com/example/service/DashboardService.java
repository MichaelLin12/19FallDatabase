package com.example.service;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.DashboardDAO;
import com.example.entity.Dashboard;


@Component
public class DashboardService {

@Autowired
DashboardDAO dashboardDAO; 


	public List<Dashboard> getdashboardList() {
		List<Dashboard> paperList = new ArrayList<Dashboard>();
		
		paperList = dashboardDAO.getdashboardList();
		
		return paperList;
	}
	
}
