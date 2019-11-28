package com.example.service;

import org.springframework.stereotype.Component;

import com.example.dao.ParticipatorDAO;
import com.example.entity.Participator;

@Component
public class ParticipatorService {
	private ParticipatorDAO participatorDAO = new ParticipatorDAO();

	public void verifyParticipator(Participator participator)
	{
		participatorDAO.verify(participator);
	}
}
