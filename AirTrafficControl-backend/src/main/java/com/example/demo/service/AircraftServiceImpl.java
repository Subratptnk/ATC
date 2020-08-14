package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.AircraftAlreadyPresentException;
import com.example.demo.exception.AircraftnotFoundException;
import com.example.demo.model.Aircraft;
import com.example.demo.repo.AIrcraftRepo;


@Service
@Transactional
public class AircraftServiceImpl implements AircraftService {
	
	@Autowired
	AIrcraftRepo repo;

	@Override
	public Iterable<Aircraft> start() {
		
		return repo.findAll();
	}

	@Override
	public Aircraft viewAircraftById(String flightcode) {
		Optional<Aircraft> findAricraft = repo.findById(flightcode);
		
		if(findAricraft.isPresent())
		{
			return findAricraft.get();
		}
		else
		{
			throw new AircraftnotFoundException("Aircraft not found");
		}
	
	}

	@Override
	public ResponseEntity<Aircraft> enqueue(Aircraft aircraft) {
		Optional<Aircraft> findAircraft  = repo.findById(aircraft.getFlightCode());
		try
		{
			if(!findAircraft.isPresent())
			{
				repo.save(aircraft);
				return new ResponseEntity<Aircraft>(aircraft,HttpStatus.OK);
			}
			else
			{
				throw new AircraftAlreadyPresentException("aircraft already present");
			}
		}
		catch (AircraftAlreadyPresentException e) {
			
			return new ResponseEntity<Aircraft>(aircraft,HttpStatus.NOT_FOUND);
		}
	
	}


	@Override
	public Aircraft dequeue(Aircraft aircraft) {
		Optional<Aircraft> findAricraft = repo.findById(aircraft.getFlightCode());
	
		try
		{
			if(findAricraft.isPresent())
			{
				repo.delete(aircraft);
			}
		}
	
		catch (AircraftnotFoundException e) {
			throw new AircraftnotFoundException("Aircraft not found");
		}
		return aircraft;
		
	}

	
	
}
