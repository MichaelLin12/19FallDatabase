package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ReviewDAO;
import com.example.entity.Review;

@Component
public class ReviewService {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public void insertReview(Review review) {
		reviewDAO.insertReview(review);
		
	}
}
