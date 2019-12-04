package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Participator;
import com.example.placeholder.Participator_Registration;

@Controller
public class RegisterController {

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String displayRegister(@ModelAttribute Participator_Registration participator,Model model)
	{
		participator= new Participator_Registration();
		model.addAttribute("register", participator);
		return "register";
	}
	
	@RequestMapping(value="/register_review",method=RequestMethod.POST)
	public String displayRegisterReview(@ModelAttribute Participator_Registration participator,Model model)
	{
		model.addAttribute("register",participator);
		return "register";
	}
}
