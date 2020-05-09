package com.tournow.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class ServerController {
	@Autowired
	private  DiscoveryClient discoveryClient;
	
	private ComsumerControllerClient consumerControllerClient = new ComsumerControllerClient();
	
	
	@RequestMapping(value = "/getCarsByCity", method = RequestMethod.GET)
	@ResponseBody
	public String getByCity(@RequestParam("city") String city) throws RestClientException, IOException
	{
		//Return message when user enter the wrong city name
		if (!city.equals("Dublin")&&!city.equals("Cork")&&!city.equals("Galway"))
		{
			return  "Worng city name"+", you enter: "+city;
		}
		String serverName = city+"-server";

		List<ServiceInstance> instances=discoveryClient.getInstances(serverName);
		
		//Return message if the server is not found in Eureka server
		if(instances==null)
		{
			return "No such server registered to the eureka server";
		}
		
		ServiceInstance serviceInstance=instances.get(0);
		String Url = serviceInstance.getUri().toString()+"/getCars";	
		String response = consumerControllerClient.getResponseThoughUrl(Url);
		return response;
	}
	
	@RequestMapping(value = "/getCarsByIP", method = RequestMethod.GET)
	@ResponseBody
	public String getByIP(@RequestParam("ip") String ip) throws RestClientException, IOException
	{
		
		String city = consumerControllerClient.searchCity(ip);
		
		//Return message when user enter the wrong city name
		if (!city.equals("Dublin")&&!city.equals("Cork")&&!city.equals("Galway"))
		{
			return  "Worng city name"+", you enter: "+city;
		}
		String serverName = city+"-server";
		
		List<ServiceInstance> instances=discoveryClient.getInstances(serverName);
		
		//Return message if the server is not found in Eureka server
		if(instances==null)
		{
			return "No such server registered to the eureka server";
		}
		
		ServiceInstance serviceInstance=instances.get(0);
		String Url = serviceInstance.getUri().toString()+"/getCars";
		String response = consumerControllerClient.getResponseThoughUrl(Url);		
		return response;
	}
	
	
	

	@RequestMapping(value = "/rent", method = RequestMethod.GET)
	@ResponseBody
	public String rentCar(@RequestParam("city") String city, @RequestParam("id") Integer id) throws RestClientException, IOException
	{	
		String serverName = city+"-server";
		
		List<ServiceInstance> instances=discoveryClient.getInstances(serverName);
		
		//Return message if the server is not found in Eureka server
		if(instances==null)
		{
			return "No such server registered to the eureka server";
		}
		
		ServiceInstance serviceInstance=instances.get(0);
		String Url = serviceInstance.getUri().toString()+"/rent?id="+id;
		
		String response = consumerControllerClient.getResponseThoughUrl(Url);
		return response;
	}
	
	
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	@ResponseBody
	public String returnCar(@RequestParam("city") String city, @RequestParam("id") Integer id) throws RestClientException, IOException
	{		
		String serverName = city+"-server";
		
		List<ServiceInstance> instances=discoveryClient.getInstances(serverName);
		
		//Return message if the server is not found in Eureka server
		if(instances==null)
		{
			return "No such server registered to the eureka server";
		}
		
		ServiceInstance serviceInstance=instances.get(0);
		String Url = serviceInstance.getUri().toString()+"/return?id="+id;

		String response = consumerControllerClient.getResponseThoughUrl(Url);
		return response;	
		
	}
	
//	@Bean
//	public  ComsumerControllerClient  consumerControllerClient()
//	{
//		return  new ComsumerControllerClient();
//	}
	
}