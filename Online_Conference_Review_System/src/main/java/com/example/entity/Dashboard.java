package com.example.demo.domain;

public class Dashboard {
	
	private String revemail;
	private int paperid;
	private int techmerit;
	private int readability;
	private int originality;
	private int relavance;
	private int overallrecomm;
	private String commentforcommittee;
	private String commentforauthor;
	
	/**
	 * @param revemail
	 * @param paperid
	 * @param techmerit
	 * @param readability
	 * @param originality
	 * @param relavance
	 * @param overallrecomm
	 * @param commentforcommittee
	 * @param commentforauthor
	 */
	
	public Dashboard(String revemail, int paperid, int techmerit,
			int readability, int originality, int relavance, int overallrecomm,
			String commentforcommittee, String commentforauthor) {
		super();
		this.revemail = revemail;
		this.paperid = paperid;
//		this.title = title;
		this.techmerit = techmerit;
		this.readability = readability;
		this.originality = originality;
		this.relavance = relavance;
		this.overallrecomm = overallrecomm;
		this.commentforcommittee = commentforcommittee;
		this.commentforauthor = commentforauthor;
	}
	/**
	 * @return the revemail
	 */
	public String getRevemail() {
		return revemail;
	}
	/**
	 * @param revemail the revemail to set
	 */
	public void getRevemail(String revemail) {
		this.revemail = revemail;
	}
	/**
	 * @return the paperid
	 */
	public int getPaperid() {
		return paperid;
	}
	/**
	 * @param revemail the revemail to set
	 */
	public void getPaperid(int paperid) {
		this.paperid = paperid;
	}
	/**
	 * @return the techmerit
	 */
	public int getTechmerit() {
		return techmerit;
	}

	/**
	 * @return the readability
	 */
	public int getReadability() {
		return readability;
	}


	/**
	 * @return the originality
	 */
	public int getOriginality() {
		return originality;
	}

	/**
	 * @return the relavance
	 */
	public int getRelavance() {
		return relavance;
	}
	

	/**
	 * @return the overallrecomm
	 */
	public int getOverallrecomm() {
		return overallrecomm;
	}

	/**
	 * @return the commentforcommittee
	 */
	public String getCommentforcommittee() {
		return commentforcommittee;
	}
	
	/**
	 * @return the commentforauthor
	 */
	public String getCommentforauthor() {
		return commentforauthor;
	}
}
