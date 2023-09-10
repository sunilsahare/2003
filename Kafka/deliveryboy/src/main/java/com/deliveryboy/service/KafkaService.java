package com.deliveryboy.service;

import com.deliveryboy.constants.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger LOG = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLiveLocation(String location) {
        kafkaTemplate.send(AppConstant.LOCATION_UPDATE_TOPIC, location);
        LOG.info("Message produced: {} ", location);
        return true;
    }

}
