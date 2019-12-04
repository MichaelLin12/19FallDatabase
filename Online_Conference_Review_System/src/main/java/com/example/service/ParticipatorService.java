package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ParticipatorDAO;
import com.example.entity.Participator;

@Component
public class ParticipatorService {
	@Autowired
	private ParticipatorDAO participatorDAO;

	public ArrayList<Participator> verifyParticipator(Participator participator)
	{
		ArrayList<Participator> verification=participatorDAO.verify(participator);
		return verification;
	}
	
	public void insertParticipator(Participator participator)
	{
		participatorDAO.insert(participator);
	}
}
