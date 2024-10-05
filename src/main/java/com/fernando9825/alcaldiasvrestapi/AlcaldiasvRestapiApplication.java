package com.fernando9825.alcaldiasvrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class AlcaldiasvRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlcaldiasvRestapiApplication.class, args);
	}

}
