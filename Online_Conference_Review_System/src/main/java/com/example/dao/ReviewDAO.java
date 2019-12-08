package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Review;
import com.example.mapper.ConferenceMapper;

@Component
public class ReviewDAO {
	@Autowired
	private ConferenceMapper mapper;
	public void insertReview(Review review) {
		mapper.insertReview(review);	
	}

}
