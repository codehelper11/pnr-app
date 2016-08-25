package com.droid.app.http.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class IrctcWebClient {


    private static final String HEADER_REFERER_NAME = "Referer";
    private RestTemplate restTemplate;

    @Value("${irctc.pnr.enquiry.url}")
    private String pnrUrl;

    @Value("${irctc.referer.header.value}")
    private String refererHeaderValue;

    @Value("${pnr.number.element.name}")
    private String pnrNumberElementName;

    @Value("${irctc.mandatory.header.first.name}")
    private String mandatoryHeaderOneName;

    @Value("${irctc.mandatory.header.first.value}")
    private String mandatoryHeaderOneValue;

    @Value("${irctc.mandtory.header.second.name}")
    private String mandatoryHeaderTwoName;

    @Value("${irctc.mandtory.header.second.value}")
    private String mandatoryHeaderTwoValue;


    public IrctcWebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

      public String queryPnr(String pnrNumber) {
        ResponseEntity<String> s = restTemplate.exchange(pnrUrl, HttpMethod.POST, getRequestEntityForPnr(pnrNumber), String.class);
        System.out.println(s.getBody());
        return s.getBody();
    }

    private HttpEntity<MultiValueMap<String, String>> getRequestEntityForPnr(String pnrNumber){
        return new HttpEntity<>(getPostRequestParams(pnrNumber), getRequestHeaders());
    }

    private MultiValueMap<String, String> getPostRequestParams(String pnrNumber){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add(pnrNumberElementName, pnrNumber);
        map.add(mandatoryHeaderOneName, mandatoryHeaderOneValue);
        map.add(mandatoryHeaderTwoName, mandatoryHeaderTwoValue);
        return map;
    }

    private HttpHeaders getRequestHeaders(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HEADER_REFERER_NAME, refererHeaderValue);
        return requestHeaders;
    }

    public static void main(String[] args) {
        new IrctcWebClient(new RestTemplate()).queryPnr("8750135595");
    }
}
