package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.PaperDAO;
import com.example.entity.Paper;

@Component
public class PaperService {
	@Autowired
	private PaperDAO paperDAO;

	public Paper getPaper(Paper paper) {
		return paperDAO.getPaper(paper);
	}

	public int getMaxID() {
		return paperDAO.getMaxID();
	}

	public int getMinID() {
		return paperDAO.getMinID();
	}
}
