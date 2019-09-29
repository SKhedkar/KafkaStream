package com.infy.accountPublisher.service;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.accountPublisher.entity.Account;

@Service
public class AccountService {

	@Autowired
	private KafkaTemplate<String, Account> kafkaTemplate;

	public static final String KAFKA_TOPIC = "topicTwo";

	public String publishDataToTopic() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Account account = objectMapper.readValue(new File("AccountData.json"), Account.class);
		kafkaTemplate.send(KAFKA_TOPIC, account);
		return "Success";
	}

}
