package com.deliveryboy.config;

import com.deliveryboy.constants.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(AppConstant.LOCATION_UPDATE_TOPIC)
//                .partitions(1)
//                .replicas(2)
                .build();
    }

}
