package com.example.spiderGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com"})
public class SpiderGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiderGameApplication.class, args);
	}

}
