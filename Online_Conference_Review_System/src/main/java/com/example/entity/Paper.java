package com.example.entity;

public class Paper {
	private int id;
	private String title;
	private String filename;
	private String abstract1;
	private String rating;
	private String contactauthoremail;
	
	
	public Paper(int id, String title, String filename, String abstract1, String contact_author, String rating) {
		super();
		this.id = id;
		this.title = title;
		this.filename = filename;
		this.abstract1 = abstract1;
		this.contactauthoremail = contact_author;
		this.rating = rating;
	}
	public Paper()
	{
		this.id=12001;
		this.title="";
		this.filename="";
		this.abstract1="";
		this.contactauthoremail="";
		this.rating="";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getAbstract1() {
		return abstract1;
	}
	public void setAbstract1(String abstract1) {
		this.abstract1 = abstract1;
	}
	public String getContactauthoremail() {
		return contactauthoremail;
	}
	public void setContactauthoremail(String contact_author) {
		this.contactauthoremail = contact_author;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Paper [id=" + id + ", title=" + title + ", filename=" + filename + ", abstract1=" + abstract1
				+ ", rating=" + rating + ", contact_author=" + contactauthoremail + "]";
	}
	
	
}
