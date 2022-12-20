package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.EmailRequest;
import com.shop.service.EmailService;

@RestController
@CrossOrigin("*")
public class EmailController {
	@Autowired
	private EmailService emailService;
	@RequestMapping(value="/sendEmail", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
//		System.out.println(request);
		if(result)
		{
			return ResponseEntity.ok("Mail sent");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Mail not sent");
		}
	}
}
