package com.picom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PicomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicomApplication.class, args);
	}

}
