package com.tournow;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tournow.controllers.*;


@SpringBootApplication
@EnableDiscoveryClient
public class BrokerServer {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				BrokerServer.class, args);
		
//		ServerController consumerControllerClient=ctx.getBean(ServerController.class);
//		System.out.println(consumerControllerClient);
		
	}
	
	@Bean
	public  ComsumerControllerClient  consumerControllerClient()
	{
		return  new ComsumerControllerClient();
	}
	
	//Globally setting for Cross Region Request
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/getCarsByIP").allowedOrigins("http://localhost:9000");
                registry.addMapping("/getCarsByCity").allowedOrigins("http://localhost:9000");
                registry.addMapping("/rent").allowedOrigins("http://localhost:9000");
                registry.addMapping("/return").allowedOrigins("http://localhost:9000"); 
            }
        };
    }
}
