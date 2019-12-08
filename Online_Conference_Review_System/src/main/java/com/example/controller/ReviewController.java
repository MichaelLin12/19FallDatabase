package com.example.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

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

import com.example.InvalidAttributeException;
import com.example.entity.Paper;
import com.example.entity.Review;
import com.example.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService service;
	private Paper paper;
	
	@RequestMapping(value="/review",method=RequestMethod.GET)
	public String displayReview(@ModelAttribute Paper paper,Model model) throws IOException
	{
		this.paper=paper;
		model.addAttribute("review",new Review());
		return"review";
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

	@RequestMapping(value="/review",method=RequestMethod.POST)
	public String showReview(@ModelAttribute Review review,Model model)
	{
		model.addAttribute("review",review);
		return"review";
	}
	
	@RequestMapping(value="/redirect_review",method=RequestMethod.POST)
	public ModelAndView redirectFromReview(@ModelAttribute Review review, HttpServletRequest request) throws Exception
	{
		System.out.println(review);
		review.setId(paper.getId());
		review.setEmail(read("reserve"));
		checkAttributes(review);
		service.insertReview(review);
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		return new ModelAndView("redirect:/dashboard");
	}
	
	private void checkAttributes(Review review) throws Exception {
		if(!((review.getOriginality()+"").matches("[1-9]|10")))
			throw new InvalidAttributeException("Originality must have value 1-10");
		else if(!((review.getOverallRecommendation()+"").matches("[1-9]|10")))
			throw new InvalidAttributeException("Overall Recommendation must have value 1-10");
		else if(!((review.getReadability()+"").matches("[1-9]|10")))
			throw new InvalidAttributeException("Readability must have value 1-10");
		else if(!((review.getRelevance()+"").matches("[1-9]|10")))
			throw new InvalidAttributeException("Relavance must have value 1-10");
		else if(!((review.getTech()+"").matches("[1-9]|10")))
			throw new InvalidAttributeException("Tech Merit must have value 1-10");
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ModelAndView handleIntegrityException(@ModelAttribute Review review, Model model, HttpServletRequest request)
	{
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("review", review);
	    mav.addObject("incorrect","You have already reviewed this paper");
	    mav.setViewName("review");
	    return mav;
	}
	@ExceptionHandler(InvalidAttributeException.class)
	public ModelAndView handleInvalidAttributeException(InvalidAttributeException e, HttpServletRequest request)
	{
		//ModelAndView model = new ModelAndView();
		//request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
		ModelAndView mav = new ModelAndView("redirect:/review");
		mav.addObject("incorrect",e.getMessage());
		//mav.addObject("review",review);
		mav.setViewName("review");
		return mav;
	}
}
