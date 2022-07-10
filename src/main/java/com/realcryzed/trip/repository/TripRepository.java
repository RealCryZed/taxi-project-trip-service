package com.realcryzed.trip.repository;

import com.realcryzed.trip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    Trip findTripByTripId(Integer id);
}
