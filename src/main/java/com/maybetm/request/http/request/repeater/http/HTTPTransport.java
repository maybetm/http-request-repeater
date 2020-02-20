package com.maybetm.request.http.request.repeater.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author zebzeev-sv
 * @version 06.01.2020 16:25
 */
public class HTTPTransport implements IHTTPTransport {

	private final RestTemplate restTemplate;

	public HTTPTransport() {
		this.restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(new LoggingInterceptor()));
		restTemplate.setMessageConverters(Collections.singletonList(getStringHttpMessageConverter()));
	}

	public ResponseEntity<String> request(String url, String payload) {
		HttpEntity<String> httpEntity = new HttpEntity<>(payload, getHeaders());

		return restTemplate.postForEntity(url, httpEntity, String.class);
	}

	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
		return headers;
	}

	public StringHttpMessageConverter getStringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		converter.setWriteAcceptCharset(false);
		return converter;
	}
}
