package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Participator;
import com.example.mapper.ConferenceMapper;

public class AuthorDAO {
	@Autowired
	ConferenceMapper mapper;
	public void insert(Participator participator) {
		mapper.insertAuthor(participator);
		
	}

}
