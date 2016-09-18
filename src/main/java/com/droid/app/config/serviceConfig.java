package com.droid.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vinay on 22/8/16.
 */
@Configuration
public class serviceConfig {

    @Bean
    @ConfigurationProperties(prefix = "custom.rest.connection")
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory()
    {
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    public RestTemplate customRestTemplate()
    {
        return new RestTemplate(customHttpRequestFactory());
    }

}
