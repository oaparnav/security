package com.katta.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katta.security.command.CommandClass;

@RestController
public class SpringSecurityController {
	
	private CommandClass commandClass;
	
	public SpringSecurityController(CommandClass commandClass) {
		super();
		this.commandClass = commandClass;
	}

	@GetMapping("/sayHello")
	public String getData() {
		
		return commandClass.doRun();
		
	}

}
