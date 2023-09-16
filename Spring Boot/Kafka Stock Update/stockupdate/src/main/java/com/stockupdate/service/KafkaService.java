package com.stockupdate.service;

import com.stockupdate.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static Integer STOCK_PRICE = 19500;

    private Random random = new Random();

    private Logger LOG = LoggerFactory.getLogger(KafkaService.class);

    public void updateNiftyStockPrice() {
        double randomNumber = Math.random();
        STOCK_PRICE = STOCK_PRICE + random.nextInt(10);

        if (randomNumber % 2 == 0) {
            STOCK_PRICE = STOCK_PRICE - random.nextInt(20);
        }

        if (STOCK_PRICE > 19620 && STOCK_PRICE < 19700) {
            STOCK_PRICE = STOCK_PRICE - random.nextInt(200);
        }

        kafkaTemplate.send(AppConstant.NIFTY_TOPIC, String.valueOf(STOCK_PRICE));

        LOG.info("Produced Nifty Price - {}", STOCK_PRICE);
    }

}
