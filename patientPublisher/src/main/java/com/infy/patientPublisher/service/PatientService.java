package com.infy.patientPublisher.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.patientPublisher.entity.Patient;

@Service
public class PatientService {

	@Autowired
	private KafkaTemplate<String, Patient> kafkaTemplate;

	public static final String KAFKA_TOPIC = "topicOne";

	public String publishDataToTopic() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Patient patient = objectMapper.readValue(new File("PatientData.json"), Patient.class);
		kafkaTemplate.send(KAFKA_TOPIC, patient);
		return "Success";
	}

}
