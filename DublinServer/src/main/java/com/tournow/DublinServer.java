package com.tournow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class DublinServer {

	public static void main(String[] args) {
		SpringApplication.run(DublinServer.class, args);
	}
}
