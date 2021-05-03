package com.kafkademo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkademo.ProjectDetails;

@Service
public class KafkaProducerService {
	
	 Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
	 
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    String kafkaTopic = "demoproducer-topicexamples";

    public void send(Object details) {

    	logger.info(String.format("Project details created -> %s", details));
        kafkaTemplate.send(kafkaTopic, details);
    }
}
