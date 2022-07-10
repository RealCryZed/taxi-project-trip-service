package com.realcryzed.trip.vo;

import com.realcryzed.trip.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateValueObject {

    private Trip trip;
    private User user;
    private Driver driver;
}
