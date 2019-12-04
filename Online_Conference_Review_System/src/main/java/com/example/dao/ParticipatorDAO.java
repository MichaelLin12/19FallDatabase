package com.example.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Participator;
import com.example.mapper.ConferenceMapper;

@Component
public class ParticipatorDAO {
	@Autowired
	private ConferenceMapper mapper;
	
	public ArrayList<Participator> verify(Participator participator) {
		ArrayList<Participator> verification=mapper.verify(participator);
		return verification;
	}

	public void insert(Participator participator) {
		mapper.insert(participator);
		
	}

}
