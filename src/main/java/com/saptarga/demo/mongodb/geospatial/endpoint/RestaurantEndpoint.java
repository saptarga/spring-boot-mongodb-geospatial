package com.saptarga.demo.mongodb.geospatial.endpoint;

import com.saptarga.demo.mongodb.geospatial.dto.RequestAddRestaurant;
import com.saptarga.demo.mongodb.geospatial.model.Restaurant;
import com.saptarga.demo.mongodb.geospatial.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
