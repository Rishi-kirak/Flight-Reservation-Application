package com.rishi.flightcheckinapplication.integration;

import com.rishi.flightcheckinapplication.integration.dto.Reservation;
import com.rishi.flightcheckinapplication.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
