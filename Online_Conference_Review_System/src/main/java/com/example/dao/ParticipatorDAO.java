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
		ArrayList<Participator> verification=mapper.verifyParticipator(participator);
		return verification;
	}

	public void insertParticipator(Participator participator) {
		mapper.insertParticipator(participator);	
	}
	
	public void insertAuthor(Participator participator) {
		mapper.insertAuthor(participator);	
	}
	
	public void insertReviewer(Participator participator) {
		mapper.insertReviewer(participator);	
	}

}
