package com.stockupdate.controller;

import com.stockupdate.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/nse")
public class StockRestController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/nifty")
    public ResponseEntity<String> updateNifty() {
        int numOfTimesPriceMovement = new Random().nextInt(10);
        for (int i = 0; i < numOfTimesPriceMovement; i++) {
            kafkaService.updateNiftyStockPrice();
        }
        return new ResponseEntity<>("Nifty Price Successfully Updated.", HttpStatus.OK);
    }
}
