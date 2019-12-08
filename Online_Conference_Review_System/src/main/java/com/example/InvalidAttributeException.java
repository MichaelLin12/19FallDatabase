package com.example;

public class InvalidAttributeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAttributeException()
	{
		super();
	}
	
	public InvalidAttributeException(String s)
	{
		super(s);
	}
}
