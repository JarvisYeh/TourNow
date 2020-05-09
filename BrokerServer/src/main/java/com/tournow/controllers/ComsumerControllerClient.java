package com.tournow.controllers;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import model.CityResponse;

@Controller
public class ComsumerControllerClient {
	
	
	private  Gson gson = new Gson();
	
	public  String getResponseThoughUrl(String Url)
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(Url,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return response.getBody();
	}
	
	public  String searchCity(String ip) { 
		String access_key = "2dc9de58a43d84d05c924e0c8ab335d3";
		String requestUrl = "http://api.ipstack.com/"+ ip + "?access_key=" + access_key + "&fields=city";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
			response=restTemplate.exchange(requestUrl,
					HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		CityResponse cityResponse = gson.fromJson(response.getBody(), CityResponse.class);
		return cityResponse.getCity();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
