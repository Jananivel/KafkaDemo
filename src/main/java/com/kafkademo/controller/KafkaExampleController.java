package com.kafkademo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkademo.ProjectDetails;
import com.kafkademo.repository.KafkaProdRepository;
import com.kafkademo.service.KafkaConsumerService;
import com.kafkademo.service.KafkaProducerService;

@RestController
@RequestMapping(value = "/techgeeknext-kafka/")
public class KafkaExampleController {

	Logger logger = LoggerFactory.getLogger(KafkaExampleController.class);
	@Autowired
	KafkaProducerService kafkaProducer;

	@Autowired
	KafkaConsumerService kafkaConsumer;

	@Autowired
	KafkaProdRepository repo;

	@PostMapping(value = "/producer")
	public void sendMessage(@RequestBody ProjectDetails projDetails) {
		Object projDetails1 = repo
				.save(new ProjectDetails(projDetails.getProjectName(), projDetails.getProjectDescription()));
		kafkaProducer.send(projDetails1);
		logger.info("Message sent Successfully to the Kafka topic demoproducer-topic");
	}

	@GetMapping(value = "/consumer")
	public List<ProjectDetails> getMessage() {
		
		List<ProjectDetails> messages = KafkaConsumerService.messages;
		

		logger.info("Message received Successfully from the Kafka topic demoproducer-topic" + messages);

		return messages;
	}

}
