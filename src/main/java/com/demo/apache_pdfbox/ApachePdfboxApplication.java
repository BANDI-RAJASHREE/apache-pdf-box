package com.demo.apache_pdfbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApachePdfboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApachePdfboxApplication.class, args);
	}

}
