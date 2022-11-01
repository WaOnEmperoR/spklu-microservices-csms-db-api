package com.fastcharging.csmsdbapi;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.google.maps.GeoApiContext;

@SpringBootApplication
@EnableEurekaClient
public class SpkluMicroservicesCsmsDbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpkluMicroservicesCsmsDbApiApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
		return application.sources(SpkluMicroservicesCsmsDbApiApplication.class);  
	}  

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Value("${com.google.api.maps.key}")
	String mapsApiKey;

	@Bean
	public GeoApiContext myContext() {
		return new GeoApiContext.Builder().apiKey(mapsApiKey).build();
	}
	
	@PreDestroy
	public void destroyGeoContext() {
		myContext().shutdown();
	}

}
