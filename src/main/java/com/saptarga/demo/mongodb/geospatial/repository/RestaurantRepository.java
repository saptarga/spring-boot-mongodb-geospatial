package com.saptarga.demo.mongodb.geospatial.repository;

import com.saptarga.demo.mongodb.geospatial.model.Restaurant;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    GeoResults<Restaurant> findByLocationNear(Point point, Distance distance);
}
