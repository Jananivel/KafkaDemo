package com.kafkademo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkademo.ProjectDetails;

@Service
public class KafkaConsumerService {

	Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	public static List<ProjectDetails> messages = new ArrayList<>();

	@KafkaListener(topics = "demoproducer-topicexamples", groupId = "group_id")
	public void listen(ProjectDetails message) {

		messages.add(message);

		logger.info("Received Messasge : " + messages);

	}
}
