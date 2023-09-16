package com.stockuser.config;

import com.stockuser.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private Logger LOG = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = AppConstant.NIFTY_TOPIC, groupId = AppConstant.GROUP_ID)
    public void currentNiftyStockPrice(String price) {
        LOG.info("Current Nifty Price - {}", price);
    }

}
