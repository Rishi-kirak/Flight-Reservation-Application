package com.rishi.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.flightreservationapplication.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
