package com.rishi.flightreservationapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.flightreservationapplication.dto.ReservationUpdateRequest;
import com.rishi.flightreservationapplication.entities.Reservation;
import com.rishi.flightreservationapplication.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRespository;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRespository.findOne(id);
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRespository.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckIn());
		return reservationRespository.save(reservation);
		
		
	}

}
