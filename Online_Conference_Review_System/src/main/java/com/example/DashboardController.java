package com.example;

import java.awt.print.Paper;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dashboard;
import com.example.demo.service.DashboardService;



@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	DashboardService dashService;
		
    @RequestMapping(value = "/dashboardDisplay", method = RequestMethod.GET)
    public String disDashboard(Model model) {
    	
    	List<Dashboard> paperList = new ArrayList<Dashboard>();
    	
    	paperList = dashService.getdashboardList();
        model.addAttribute("paperList",paperList);
        logger.info("test" + paperList);
        return "dashDisplay";
    	
    }
	
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String displayDashboard(@ModelAttribute Paper paper, Model model) {

//    	dashService.displayDashboard();
    	model.addAttribute("message","You are reviewer # 116");    	
    	
        return "displayDashboard";
    }
}
