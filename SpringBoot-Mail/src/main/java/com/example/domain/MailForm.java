package com.example.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MailForm {

	@NotEmpty
	private String toName;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String text;
	
	@NotEmpty
	private String name;

}
