package com.realcryzed.trip.service;

import com.realcryzed.trip.model.Trip;
import com.realcryzed.trip.repository.TripRepository;
import com.realcryzed.trip.vo.Driver;
import com.realcryzed.trip.vo.ResponseTemplateValueObject;
import com.realcryzed.trip.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip getTripByTripId(Integer id) {
        return tripRepository.findTripByTripId(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public ResponseTemplateValueObject getTrip(Integer id) {
        ResponseTemplateValueObject template = new ResponseTemplateValueObject();
        Trip trip = tripRepository.findTripByTripId(id);

        User user = new User();
        Driver driver = new Driver();
        try {
            user =
                    restTemplate.getForObject("http://USER-SERVICE/user/" + trip.getUserId(),
                            User.class);
        } catch (Exception e) {log.error("User not found");}

        try {
            driver =
                    restTemplate.getForObject("http://DRIVER-SERVICE/driver/" + trip.getDriverId(),
                            Driver.class);
        } catch (Exception e) {log.error("Driver not found");}

        template.setTrip(trip);
        template.setUser(user);
        template.setDriver(driver);

        return template;
    }
}
