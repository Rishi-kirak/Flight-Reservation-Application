package com.rishi.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.flightreservationapplication.entities.Passenger;

public interface PassengerRespository extends JpaRepository<Passenger, Long> {

}
