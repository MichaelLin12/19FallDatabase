package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Paper;
import com.example.mapper.ConferenceMapper;

@Component
public class PaperDAO {
	@Autowired
	private ConferenceMapper mapper;
	
	public Paper getPaper(Paper paper) {
		//System.out.println(paper);
		Paper temp = mapper.getPaper(paper);
		//why?
		//System.out.println(temp);
		String abstract1=mapper.getAbstract(paper);
		temp.setAbstract1(abstract1);
		String rating = mapper.getRating(paper);
		temp.setRating(rating);
		//System.out.println(temp);
		temp.setId(paper.getId());
		return temp;
	}

	public int getMaxID() {
		return mapper.getMaxID();
	}

	public int getMinID() {
		return mapper.getMinID();
	}


}
