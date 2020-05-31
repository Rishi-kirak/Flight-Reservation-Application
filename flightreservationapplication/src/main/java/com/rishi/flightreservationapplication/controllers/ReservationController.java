package com.rishi.flightreservationapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishi.flightreservationapplication.dto.ReservationRequest;
import com.rishi.flightreservationapplication.entities.Flight;
import com.rishi.flightreservationapplication.entities.Reservation;
import com.rishi.flightreservationapplication.repos.FlightRepository;
import com.rishi.flightreservationapplication.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap ) {
		Flight flight= flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap ) {
		
		Reservation reservation = reservationService.bookFlight(request);
		
		modelMap.addAttribute("msg", "Reservation created successfully and reservation id is : "+reservation.getId());
		return "reservationConfirmation";
		
	}
	

}
