package com.realcryzed.trip.controller;

import com.realcryzed.trip.model.Trip;
import com.realcryzed.trip.service.TripService;
import com.realcryzed.trip.vo.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/add-trip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/trip/{id}")
    public ResponseTemplateValueObject getTrip(@PathVariable Integer id) {
        return tripService.getTrip(id);
    }
}
