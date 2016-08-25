package com.droid.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vinay on 22/8/16.
 */
@Configuration
public class serviceConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
