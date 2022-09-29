package com.github.kvncont.istioclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("service1")
public class Service1Controller {
    @Value("${url.service1.success}")
    String UrlService1Success;

    @Value("${url.service1.error}")
    String UrlService1Error;

    @GetMapping("/success")
    public ResponseEntity<String> service1Success() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code Client - Service1 Success");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(UrlService1Success, String.class);
        return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<String> service1Error() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code Client - Service1 Error");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(UrlService1Error, String.class);
        return new ResponseEntity<String>(result, responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
