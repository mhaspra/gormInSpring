package com.zuehlke.haa.gormInSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GormInSpringApplication {
	private BootStrap bootStrap;

	@Autowired
	public GormInSpringApplication(BootStrap bootStrap) {
		this.bootStrap = bootStrap;
	}

	public static void main(String[] args) {
		SpringApplication.run(GormInSpringApplication.class, args);
	}

	@PostConstruct
	private void init() {
		bootStrap.init();
	}
}
