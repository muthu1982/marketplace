package com.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
/**
 * 
 * @author mthandapani
 *
 */
public class MainApp { 

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
