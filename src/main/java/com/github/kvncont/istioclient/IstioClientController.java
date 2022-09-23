package com.github.kvncont.istioclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IstioClientController {

    @Value("${url.client.ok}")
    String UrlClientOk;

    @Value("${url.client.error}")
    String UrlClientError;

    @GetMapping("/client/ok")
    public ResponseEntity<String> clientOk() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code Client Ok");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(UrlClientOk, String.class);
        return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/client/error")
    public ResponseEntity<String> clientError() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code Client Error");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(UrlClientError, String.class);
        return new ResponseEntity<String>(result, responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
