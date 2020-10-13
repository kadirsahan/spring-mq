package com.example.kafkamq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class KafkaMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMqApplication.class, args);
	}

}
