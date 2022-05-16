package com.gdelgado.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		//Conexion a DB
		MovieDbConnection conn = new MovieDbConnection();
		conn.connect();
	}

}
