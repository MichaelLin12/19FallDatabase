package com.example.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Participator;
import com.example.mapper.ConferenceMapper;

@Component
public class ParticipatorDAO {
	@Autowired
	ConferenceMapper mapper;//this is null
	
	public ArrayList<Participator> verify(Participator participator) {
		System.out.println(mapper);
		ArrayList<Participator> verification=mapper.verify(participator);
		System.out.println(verification);
		return verification;
	}

}
