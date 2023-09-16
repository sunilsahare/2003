package com.stockupdate.config;

import com.stockupdate.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic niftyStockTopic() {
        return TopicBuilder
                .name(AppConstant.NIFTY_TOPIC)
//                .partitions(4)
//                .replicas(3)
                .build();
    }

}
