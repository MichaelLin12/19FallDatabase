package com.example.entity;

public class Review {
	private String email;
	private String date;
	private int id;
	private int tech;
	private int readability;
	private int originality;
	private int relevance;
	private int overallRecommendation;
	private String commentForCom;
	private String commentForAuth;
	
	
	public Review(String email, String date, int id, int tech, int readability, int originality, int relevance,
			int overallRecommendation, String commentForCom, String commentForAuth) {
		super();
		this.email = email;
		this.date = date;
		this.id = id;
		this.tech = tech;
		this.readability = readability;
		this.originality = originality;
		this.relevance = relevance;
		this.overallRecommendation = overallRecommendation;
		this.commentForCom = commentForCom;
		this.commentForAuth = commentForAuth;
	}
	
	public Review()
	{
		email="";
		date="";
		commentForCom="";
		commentForAuth="";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTech() {
		return tech;
	}
	public void setTech(int tech) {
		this.tech = tech;
	}
	public int getReadability() {
		return readability;
	}
	public void setReadability(int readability) {
		this.readability = readability;
	}
	public int getOriginality() {
		return originality;
	}
	public void setOriginality(int originality) {
		this.originality = originality;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public int getOverallRecommendation() {
		return overallRecommendation;
	}
	public void setOverallRecommendation(int overallRecommendation) {
		this.overallRecommendation = overallRecommendation;
	}
	public String getCommentForCom() {
		return commentForCom;
	}
	public void setCommentForCom(String commentForCom) {
		this.commentForCom = commentForCom;
	}
	public String getCommentForAuth() {
		return commentForAuth;
	}
	public void setCommentForAuth(String commentForAuth) {
		this.commentForAuth = commentForAuth;
	}

	@Override
	public String toString() {
		return "Review [email=" + email + ", date=" + date + ", id=" + id + ", tech=" + tech + ", readability="
				+ readability + ", originality=" + originality + ", relevance=" + relevance + ", overallRecommendation="
				+ overallRecommendation + ", commentForCom=" + commentForCom + ", commentForAuth=" + commentForAuth
				+ "]";
	}
	
}
