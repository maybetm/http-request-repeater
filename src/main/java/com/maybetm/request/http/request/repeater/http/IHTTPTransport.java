package com.maybetm.request.http.request.repeater.http;

import org.springframework.http.ResponseEntity;

/**
 * @author zebzeev-sv
 * @version 06.01.2020 16:25
 */
public interface IHTTPTransport {

	public ResponseEntity<String> request(String url, String payload);
}
