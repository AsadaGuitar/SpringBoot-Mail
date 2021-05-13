package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MailForm;
import com.example.service.MailService;

@Controller
@RequestMapping(path = "/")
public class MainController {
	
	@Autowired
	MailService mailService;

	@GetMapping
	public String viewMain(Model model) {
		model.addAttribute(new MailForm());
		return "SendForm";
	}
	
	@PostMapping(path="/send")
	public String afterSend(@Validated MailForm mailForm, 
			BindingResult result,
			Model model) {
		
		if(result.hasErrors())
			return "SendForm";
		
		try {
			mailService.sendMessage(mailForm);
		}
		catch(Exception e) {
			return "SendForm";
		}
		
		model.addAttribute(mailForm);
		return "Success";
	}
}
