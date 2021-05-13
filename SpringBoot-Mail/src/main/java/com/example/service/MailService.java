package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.domain.MailForm;

@Service
public class MailService {
	
	private static final String mailAdress = "***";

	@Autowired
	MailSender sender;
	
	public void sendMessage(MailForm form) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom(mailAdress);
		msg.setTo(form.getToName());
		msg.setSubject(form.getTitle());
		msg.setText(form.getText() + "from " + form.getName());
		
		this.sender.send(msg);
	}

	
}
