package com.saptarga.demo.mongodb.geospatial.endpoint;

import com.saptarga.demo.mongodb.geospatial.dto.RequestAddRestaurant;
import com.saptarga.demo.mongodb.geospatial.model.Restaurant;
import com.saptarga.demo.mongodb.geospatial.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
public class RestaurantEndpoint {

    private final RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant")
    public ResponseEntity<Boolean> addRestaurant(@RequestBody RequestAddRestaurant request){

        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .location(new GeoJsonPoint(request.getLongitude(), request.getLatitude()))
                .build();

        restaurantRepository.save(restaurant);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/restaurant/nearby")
    public ResponseEntity<GeoResults<Restaurant>> getRestaurantNearby(@RequestParam("latitude") double latitude,
                                                                      @RequestParam("longitude") double longitude,
                                                                      @RequestParam("distance") double distance){
        Point point = new Point(longitude, latitude);
        Distance distanceOnKm = new Distance(distance, Metrics.KILOMETERS);

        return ResponseEntity.ok(restaurantRepository.findByLocationNear(point, distanceOnKm));

    }

}
