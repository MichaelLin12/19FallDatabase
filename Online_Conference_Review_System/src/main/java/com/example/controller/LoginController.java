package com.example.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.entity.Participator;
import com.example.service.ParticipatorService;

@Controller
public class LoginController {
	@Autowired
	ParticipatorService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String displayLogin(@ModelAttribute Participator participator, Model model)
	{
		participator= new Participator("","","","","","","");
		model.addAttribute("login", participator);
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String displayLoginReview(@ModelAttribute Participator participator, Model model)
	{
		model.addAttribute("login", participator);
		return "login";
	}
	
	@RequestMapping(value="/redirect_login",method=RequestMethod.POST)
	public ModelAndView RedirectLogin(@ModelAttribute Participator participator, Model model, HttpServletRequest request)
	{
		//ParticipatorService service=new ParticipatorService();
		ArrayList<Participator> verification=service.verifyParticipator(participator);
		if(verification.size() == 0)
		{
			request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
			return new ModelAndView("redirect:/login");
		}
			
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/dashboard");
	}
}
