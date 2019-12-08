package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.example.entity.Paper;
import com.example.service.PaperService;

@Controller
public class DashboardController {
	private static int id=12001;
	
	@Autowired 
	private PaperService service;
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String showDashboard(Model model)
	{
		model.addAttribute("paper", service.getPaper(new Paper(id,"","","","","")));
		return "dashboard";
	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.POST)
	public String displayDashboard(Model model)
	{
		model.addAttribute("paper", service.getPaper(new Paper(id,"","","","","")));
		return "dashboard";
	}
	
	@RequestMapping(value="/next",method=RequestMethod.POST)
	public ModelAndView nextPaper(HttpServletRequest request)
	{
		changeID("add");
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/dashboard");
	}
	
	@RequestMapping(value="/previous",method=RequestMethod.POST)
	public ModelAndView previousPaper(HttpServletRequest request)
	{
		changeID("minus");
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/dashboard");
	}

	private void changeID(String string) {
		id+= (string.equals("add"))? 1:-1;
		int max = service.getMaxID();
		int min = service.getMinID();
		id=(id>max)? min:id;
		id=(id<min)? max:id;
	}
	
}
