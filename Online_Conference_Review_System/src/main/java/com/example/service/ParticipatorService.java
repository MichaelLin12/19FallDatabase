package com.example.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.dao.ParticipatorDAO;
import com.example.entity.Participator;

@Component
public class ParticipatorService {
	private ParticipatorDAO participatorDAO = new ParticipatorDAO();

	public ArrayList<Participator> verifyParticipator(Participator participator)
	{
		ArrayList<Participator> verification=participatorDAO.verify(participator);
		return verification;
	}
}
