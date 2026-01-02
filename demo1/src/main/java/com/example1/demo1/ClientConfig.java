package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    public RestClient userServiceClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}
