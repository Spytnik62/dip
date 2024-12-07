package ru.Tar.diplomTar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//http://localhost:8080/mainPage

@SpringBootApplication
public class DiplomTarApplication {

	public static void main(String[] args) {

		SpringApplication.run(DiplomTarApplication.class, args);
		System.out.println("Здарова я ВСТАЛ!");
	}

}
