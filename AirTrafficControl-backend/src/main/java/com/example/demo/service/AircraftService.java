package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Aircraft;

public interface AircraftService {

	/*
	 * 
	 * This is the start point where we list all the aircrafts present 
	 *
	 */
	public Iterable<Aircraft> start();
	
	/*
	 * 
	 * This is the to see a aircraft by its flightcode
	 *
	 */
	
	public Aircraft viewAircraftById(String flightcode);
	
	/*
	 * 
	 * This is the add aircraft 
	 *
	 */
	
	public ResponseEntity<Aircraft> enqueue(Aircraft aircraft);
	
	/*
	 * 
	 * This is the delete aircraft by its flightcode
	 *
	 */
	
	public Aircraft dequeue(Aircraft aircraft);
	
}
