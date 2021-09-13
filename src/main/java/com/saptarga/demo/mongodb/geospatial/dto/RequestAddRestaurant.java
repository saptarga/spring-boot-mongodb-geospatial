package com.saptarga.demo.mongodb.geospatial.dto;

import lombok.Data;

@Data
public class RequestAddRestaurant {

    private String name;

    private String address;

    private String rate;

    private Double latitude;

    private Double longitude;
}
