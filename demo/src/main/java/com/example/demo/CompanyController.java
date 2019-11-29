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
	
	@Autowired
	EmployeeService empService;
	
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String displayEmployees(Model model) {
    	
    	List<Employee> empList = new ArrayList<Employee>();
    	
    	empService = new EmployeeService();    	
    	
    	empList = empService.getEmpList();
    	
        model.addAttribute("empList",empList);
        return "empLanding";
    }
    
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public String newEmployee(@ModelAttribute Employee employee, Model model) {

    	employee = new Employee("jkl;akdjfa","akd;lfkj", "ajkl;dkjf");
    	model.addAttribute("employee",employee);
    	model.addAttribute("dnoList",populateDNo());

        return "newEmployee";
    }
    
    @RequestMapping(value = "/createNewEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {

    	empService.createNewEmployee(employee);
    	model.addAttribute("message","New Employee Added Successfully");    	
    	model.addAttribute("employee",employee);
    	model.addAttribute("dnoList",populateDNo());

    	
        return "newEmployee";
    }
    
    private List<String> populateDNo() {
    	List<String> dnoList = new ArrayList<String>();
    	dnoList.add("1");
    	dnoList.add("4");
    	dnoList.add("5");
    	dnoList.add("6");
    	dnoList.add("7");
    	dnoList.add("8");
    	
    	return dnoList;
    	
    }


    
    
    

	
}