package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Participator;
import com.example.service.ParticipatorService;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String displayLogin(@ModelAttribute Participator participator, Model model)
	{
		participator= new Participator("","","","","","","");
		model.addAttribute("login", participator);
		return "login";
	}
	
	//wrong
	@RequestMapping(value="/login_review",method=RequestMethod.POST)
	public String displayReviewedLogin(@ModelAttribute Participator participator, Model model)
	{
		ParticipatorService service=new ParticipatorService();
		ArrayList<Participator> verification=service.verifyParticipator(participator);
		if(verification.size() == 0)
		{
			model.addAttribute("login", new Participator());
			return "login";
		}
			
		model.addAttribute("login", participator);
		return "login";
	}
}
