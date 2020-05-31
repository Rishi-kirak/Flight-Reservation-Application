package com.rishi.flightreservationapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.flightreservationapplication.dto.ReservationRequest;
import com.rishi.flightreservationapplication.entities.Flight;
import com.rishi.flightreservationapplication.entities.Passenger;
import com.rishi.flightreservationapplication.entities.Reservation;
import com.rishi.flightreservationapplication.repos.FlightRepository;
import com.rishi.flightreservationapplication.repos.PassengerRespository;
import com.rishi.flightreservationapplication.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRespository passengerRespository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		
		//making payment through payment gateways
		
		Long flightId= request.getFlightId();
		Flight flight = flightRepository.findOne(flightId);
		
		Passenger passenger= new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger= passengerRespository.save(passenger);
		
		Reservation reservation= new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

	

}
