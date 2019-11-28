package com.example.dao;

import com.example.entity.Participator;
import com.example.mapper.ConferenceMapper;

public class ParticipatorDAO {
	private ConferenceMapper mapper;
	
	public void verify(Participator participator) {
		mapper.verify(participator);
	}

}
