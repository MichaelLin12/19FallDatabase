package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ParticipatorDAO;
import com.example.entity.Participator;
import com.example.entity.Topics_of_Interest;

@Component
public class ParticipatorService {
	@Autowired
	private ParticipatorDAO participatorDAO;

	public ArrayList<Participator> verifyParticipator(Participator participator)
	{
		ArrayList<Participator> verification=participatorDAO.verifyParticipator(participator);
		return verification;
	}
	
	public void insertParticipator(Participator participator)
	{
		participatorDAO.insertParticipator(participator);
	}
	
	public void insertAuthor(Participator participator) {
		participatorDAO.insertAuthor(participator);	
	}
	
	public void insertReviewer(Participator participator) {
		participatorDAO.insertReviewer(participator);
	}

	public void insertTopicsOfInterest(Topics_of_Interest topics) {
		participatorDAO.insertTopicsOfInterest(topics);
	}

	public boolean verifyReviewer(Participator participator) {
		List<String> verification= participatorDAO.verifyReviewer(participator);
		if(verification.size()==0)
			return false;
		return true;
	}
}
