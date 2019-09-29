package com.infy.accountPublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.accountPublisher.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(value = "/producerTwo")
	public String publishPatientData() {

		try {

			return accountService.publishDataToTopic();

		} catch (Exception e) {
			System.out.println("Error occured" + e.getMessage());
		}

		return "Data published on kafka topic successfully";
	}

}
