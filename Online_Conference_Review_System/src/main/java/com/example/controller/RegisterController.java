package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Participator;

@Controller
public class RegisterController {

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String displayRegister(@ModelAttribute String string,Model model)
	{
		model.addAttribute("fname","fname");
		model.addAttribute("lname","");
		model.addAttribute("minit","");
		model.addAttribute("email","");
		model.addAttribute("phone","");
		model.addAttribute("Affil","");
		model.addAttribute("password","");
		model.addAttribute("Repassword","");
		return "register";
	}
	
	@RequestMapping(value="/register_review",method=RequestMethod.POST)
	public String displayRegisterReview(@ModelAttribute String register,Model model)
	{
		System.out.print(register);
		model.addAttribute("fname",register);
		model.addAttribute("lname",register);
		model.addAttribute("minit",register);
		model.addAttribute("email",register);
		model.addAttribute("phone",register);
		model.addAttribute("Affil",register);
		model.addAttribute("password",register);
		model.addAttribute("Repassword",register);
		return "register";
	}
}
