package com.example.demo;
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

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;



@Controller
public class CompanyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	EmployeeService empService;
	
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String displayEmployees(Model model) {
    	
    	List<Employee> empList = new ArrayList<Employee>();
    	
    	empService = new EmployeeService();
    	empList = empService.getEmpList();
    	
        model.addAttribute("empList",empList);
        return "empLanding";
    }
    
    
    

	
}