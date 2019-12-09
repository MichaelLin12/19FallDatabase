package com.example.exception;


public class DuplicateRecordException extends RuntimeException {
	   private static final long serialVersionUID = 1L;
	   
	   public DuplicateRecordException(Exception e)
	   {
		   super(e);
	   }
	}
