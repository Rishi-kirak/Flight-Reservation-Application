package com.rishi.flightreservationapplication.services;

import com.rishi.flightreservationapplication.dto.ReservationRequest;
import com.rishi.flightreservationapplication.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
