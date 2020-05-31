package com.rishi.flightreservationapplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.flightreservationapplication.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
