package com.realcryzed.trip.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    private int driverId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String email;
    private String password;
}
