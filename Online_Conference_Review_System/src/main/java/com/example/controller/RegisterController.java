package com.example.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Participator;
import com.example.placeholder.Participator_Registration;
import com.example.service.ParticipatorService;


@Controller
public class RegisterController {
	@Autowired
	ParticipatorService service;
	
	private Participator_Registration errorhandling;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String displayRegister(@ModelAttribute Participator_Registration participator,Model model)
	{
		participator= new Participator_Registration();
		model.addAttribute("register", participator);
		model.addAttribute("conType",populateEntities());
		return "register";
	}
	
	@RequestMapping(value="/register_review",method=RequestMethod.POST)
	public String displayRegisterReview(@ModelAttribute Participator_Registration participatorRegistration,Model model)
	{
		errorhandling=participatorRegistration;
		boolean samePassword=check(participatorRegistration);
		if(samePassword)
		{
			Participator participator = turnToParticipator(participatorRegistration);
			service.insertParticipator(participator);
		}
		model.addAttribute("register",participatorRegistration);
		model.addAttribute("conType",populateEntities());
		return "register";
	}

	private Participator turnToParticipator(Participator_Registration participatorRegistration) {
		return new Participator(participatorRegistration.getFname(),
				participatorRegistration.getEmail(),participatorRegistration.getLname(),
				participatorRegistration.getMinit(),participatorRegistration.getPhone(),
				participatorRegistration.getAffiliation(),participatorRegistration.getPassword());
	}

	private boolean check(Participator_Registration participatorRegistration) {
		return participatorRegistration.getPassword().equals(participatorRegistration.getRepassword());
	}

	private List<String> populateEntities() {
		ArrayList<String> conList = new ArrayList<String>();
		conList.add("Author");
		conList.add("Reviewer");
		conList.add("Both");
		return conList;
	}
	
	 @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	  public ModelAndView handleIntegrityException() {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("register", errorhandling);
	    mav.addObject("conType", populateEntities());
	    mav.setViewName("register");
	    return mav;
	  }
}
