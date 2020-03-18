package com.zuehlke.haa.gormInSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GormInSpringApplication {
	private BootStrap bootStrap;

	@Autowired
	public GormInSpringApplication(BootStrap bootStrap) {
		this.bootStrap = bootStrap;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GormInSpringApplication.class, args);
		context.getBean(BootStrap.class).init();
	}
}
