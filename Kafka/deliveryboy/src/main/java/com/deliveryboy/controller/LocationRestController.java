package com.deliveryboy.controller;

import com.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationRestController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        for (int i = 0; i < 2000; i++) {
            String location = "( "+Math.round(Math.random()*100)+", "+Math.round(Math.random()*100)+" )";
            kafkaService.updateLiveLocation(location);
        }

        return new ResponseEntity<>(Map.of("message","Location updated"), HttpStatus.OK);
    }

}
