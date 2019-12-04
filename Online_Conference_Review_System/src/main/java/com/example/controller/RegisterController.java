package com.example.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String displayRegisterReview(@ModelAttribute Participator_Registration participator, Model model)
	{
		model.addAttribute("register", participator);
		model.addAttribute("conType", populateEntities());
		return "register";
	}
	
	@RequestMapping(value="/redirect_registration",method=RequestMethod.POST)
	public ModelAndView redirectRegistration(@ModelAttribute Participator_Registration participatorRegistration, Model model, HttpServletRequest request)
	{
		errorhandling=participatorRegistration;
		boolean basic_check=check(participatorRegistration);
		if(basic_check)
		{
			Participator participator = turnToParticipator(participatorRegistration);
			service.insertParticipator(participator);
			if(participatorRegistration.getConType().equals("Author"))
			{
				service.insertAuthor(participator);
			}
			else if(participatorRegistration.getConType().equals("Reviewer"))
			{
				service.insertReviewer(participator);
			}
			else if(participatorRegistration.getConType().equals("Both"))
			{
				service.insertAuthor(participator);
				service.insertReviewer(participator);
			}
			request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
			return new ModelAndView("redirect:/dashboard");
		}
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/register");
	}

	private Participator turnToParticipator(Participator_Registration participatorRegistration) {
		return new Participator(participatorRegistration.getFname().substring(0,1).toUpperCase() + 
				participatorRegistration.getFname().substring(1),
				participatorRegistration.getEmail(),participatorRegistration.getLname().substring(0,1).toUpperCase()
				+participatorRegistration.getLname().substring(1),
				participatorRegistration.getMinit().toUpperCase(),participatorRegistration.getPhone(),
				participatorRegistration.getAffiliation(),participatorRegistration.getPassword());
	}

	private boolean check(Participator_Registration participatorRegistration) {
		return participatorRegistration.getPassword().equals(participatorRegistration.getRepassword())
				&& participatorRegistration.getMinit().matches("[A-Za-z]") && participatorRegistration.getFname().matches("^[a-zA-Z-]*$")
				&& participatorRegistration.getLname().matches("^[a-zA-Z-]*$") && participatorRegistration.getPhone().matches("^[0-9]*$");
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
