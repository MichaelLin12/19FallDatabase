package com.example.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.example.entity.Participator_Registration;
import com.example.entity.Review;
import com.example.entity.Topics_of_Interest;
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
		model.addAttribute("incorrect", "");
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String displayRegisterReview(@ModelAttribute Participator_Registration participator, Model model) throws IOException
	{
		model.addAttribute("register", participator);
		model.addAttribute("conType", populateEntities());
		model.addAttribute("incorrect",readAll());
		return "register";
	}
	
	private String readAll() throws IOException {
		String error = "";
		error+=read("error");
		error+=read("error1");
		error+=read("error2");
		error+=read("error3");
		error+=read("error4");
		return error;
	}

	@RequestMapping(value="/redirect_registration",method=RequestMethod.POST)
	public ModelAndView redirectRegistration(@ModelAttribute Participator_Registration participatorRegistration, Model model, HttpServletRequest request) throws IOException
	{
		errorhandling=participatorRegistration;
		write("reserve",errorhandling.getEmail());
		boolean basic_check=check(participatorRegistration);
		if(basic_check)
		{
			Participator participator = turnToParticipator(participatorRegistration);
			service.insertParticipator(participator);
			if(participatorRegistration.getConType().equals("Author"))
			{
				service.insertAuthor(participator);
				request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
				return new ModelAndView("redirect:/authorPage");
			}
			else if(participatorRegistration.getConType().equals("Reviewer"))
			{
				service.insertReviewer(participator);
				request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
				return new ModelAndView("redirect:/addTopics");
			}
			else if(participatorRegistration.getConType().equals("Both"))
			{
				service.insertAuthor(participator);
				service.insertReviewer(participator);
				request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
				return new ModelAndView("redirect:/addTopics");
			}
		}
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/register");
	}

	private void write(String file, String string) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(string);
	    printWriter.close();
	}

	private Participator turnToParticipator(Participator_Registration participatorRegistration) {
		return new Participator(participatorRegistration.getFname().substring(0,1).toUpperCase() + 
				participatorRegistration.getFname().substring(1),
				participatorRegistration.getEmail(),participatorRegistration.getLname().substring(0,1).toUpperCase()
				+participatorRegistration.getLname().substring(1),
				participatorRegistration.getMinit().toUpperCase(),participatorRegistration.getPhone(),
				participatorRegistration.getAffiliation(),participatorRegistration.getPassword());
	}

	private boolean check(Participator_Registration participatorRegistration) throws IOException {
		boolean password = participatorRegistration.getPassword().equals(participatorRegistration.getRepassword());
		if(!password)
			write("error","Password must match the re-typed password");
		boolean minit = participatorRegistration.getMinit().matches("[A-Za-z]");
		if(!minit)
			write("error","Middle initial may only contain up to one letter");
		boolean fname = participatorRegistration.getFname().matches("[a-zA-Z-]+");
		if(!fname)
			write("error","First name must only contain letters and dashes");
		boolean lname = participatorRegistration.getLname().matches("[a-zA-Z-]+");
		if(!lname)
			write("error","Last name must only contain letters and dashes");
		boolean phone = participatorRegistration.getPhone().matches("[0-9]+");
		if(!phone)
			write("error","Phone must only contain numbers");
		return password && minit && fname && lname && phone;
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
	    mav.addObject("incorrect","email has already been used");
	    mav.setViewName("register");
	    return mav;
	  }
	 
		@RequestMapping(value="/addTopics",method=RequestMethod.GET)
		public String displayTopic(Model model)
		{
			model.addAttribute("topics",new Topics_of_Interest());
			return "topics";
		}
		
		@RequestMapping(value="/addTopics",method=RequestMethod.POST)
		public String displayTopics(Model model)
		{
			model.addAttribute("topics",new Topics_of_Interest());
			return "topics";
		}
		
		@RequestMapping(value="/redirect_topic",method=RequestMethod.POST)
		public ModelAndView displayMoreTopic(@ModelAttribute Topics_of_Interest topics,Model model,HttpServletRequest request) throws IOException
		{
			topics.setEmail(read("reserve"));
			if(!topics.getTopic().equals(""))
			{
				service.insertTopicsOfInterest(topics);
				request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
				return new ModelAndView("redirect:/addTopics");
			}
			request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
			return new ModelAndView("redirect:/dashboard");
		}

		private String read(String file) throws IOException {
			FileReader fr = new FileReader(file);
			String string ="";
			int temp;
			while((temp=fr.read())!=-1)
			{
				string+=String.valueOf((char) temp);
			}
			return string;
		}
		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public ModelAndView handleIntegrityException(SQLIntegrityConstraintViolationException e, HttpServletRequest request)
		{
			request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		    ModelAndView mav = new ModelAndView();
		    //mav.addObject("review", review);
		    mav.addObject("incorrect","duplicate interest of topic");
		    mav.setViewName("review");
		    return mav;
		}
}
