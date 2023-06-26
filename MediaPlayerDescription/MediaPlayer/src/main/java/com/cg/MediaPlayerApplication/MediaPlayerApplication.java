package com.cg.MediaPlayerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class MediaPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaPlayerApplication.class, args);
		
		
		
	}
}