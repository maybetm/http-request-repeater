package com.maybetm.request.http.request.repeater.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author zebzeev-sv
 * @version 06.01.2020 16:25
 */
public class HTTPTransport implements IHTTPTransport {

	private final RestTemplate restTemplate;
	private final HttpHeaders headers;

	public HTTPTransport(){
		this.restTemplate = new RestTemplate();
		this.headers = new HttpHeaders();

		headers.clear();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
		restTemplate.setInterceptors(Collections.singletonList(new LoggingInterceptor()));

		for (HttpMessageConverter converter : restTemplate.getMessageConverters()) {
			if (converter instanceof StringHttpMessageConverter) {
				((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
			}
		}
	}

	public ResponseEntity<String> request(String url, String payload) {
		HttpEntity<String> httpEntity = new HttpEntity<>(payload, headers);

		return restTemplate.postForEntity(url, httpEntity, String.class);
	}
}
