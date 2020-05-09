package com.tournow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CorkServer {

	public static void main(String[] args) {
		SpringApplication.run(CorkServer.class, args);
	}
}
