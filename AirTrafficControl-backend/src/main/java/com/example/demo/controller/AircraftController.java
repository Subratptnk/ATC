package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AircraftAlreadyPresentException;
import com.example.demo.exception.AircraftnotFoundException;
import com.example.demo.model.Aircraft;
import com.example.demo.service.AircraftService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/")
public class AircraftController {

	@Autowired
	AircraftService service;
	
	@GetMapping("/aircraft")
	public Iterable<Aircraft> viewAll()
	{
		return service.start();
	}
	
	@GetMapping("/{flightCode}")
	@ExceptionHandler(AircraftnotFoundException.class)
	public Aircraft getAircraftByCode(@PathVariable("flightCode") String flightCode)
	{
		return service.viewAircraftById(flightCode);
	}
	@PostMapping("/addAircraft")
	@ExceptionHandler(AircraftAlreadyPresentException.class)
	public void addAircraft(@RequestBody Aircraft aircraft)
	{
		service.enqueue(aircraft);
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	@ExceptionHandler(AircraftnotFoundException.class)
	public void removeAircraft(Aircraft aircraft)
	{
		service.dequeue(aircraft);
	}
}
