package com.example.demo.exception;


public class AircraftAlreadyPresentException extends RuntimeException {

	public AircraftAlreadyPresentException(String s)
	{
		super(s);
	}
	
}