package com.infy.patientPublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.patientPublisher.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@GetMapping(value = "/producerT1")
	public String publishPatientData() {

		try {

			return patientService.publishDataToTopic();

		} catch (Exception e) {
			System.out.println("Error occured" + e.getMessage());
		}

		return "Data published on kafka topic successfully";
	}

}
