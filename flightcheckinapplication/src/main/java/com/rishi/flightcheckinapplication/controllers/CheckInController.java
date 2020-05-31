package com.rishi.flightcheckinapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishi.flightcheckinapplication.integration.ReservationRestClientImpl;
import com.rishi.flightcheckinapplication.integration.dto.Reservation;
import com.rishi.flightcheckinapplication.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClientImpl restClient;
	
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfbags") int numberOfBags) {
		
		ReservationUpdateRequest request= new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setCheckedIn(true);
		request.setNumberOfBags(numberOfBags);
		restClient.updateReservation(request);
		return "checkInConfirmation";
		
		
	}

}
