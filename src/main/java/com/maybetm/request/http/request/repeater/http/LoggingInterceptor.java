package com.maybetm.request.http.request.repeater.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author zebzeev-sv
 * @version 05.01.2020 22:42
 */
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

	private Logger logger = LogManager.getLogger(this.getClass());

	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		logRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);


		logResponse(response);


		return response;
	}

	private void logRequest(HttpRequest request, byte[] body) {
		logger.info("URI         : {}", request.getURI());
		logger.info("Method      : {}", request.getMethod());
		logger.info("Headers     : {}", request.getHeaders());
		logger.info("Request body: {}", new String(body, StandardCharsets.UTF_8));
	}

	private void logResponse(ClientHttpResponse response) throws IOException {
		logger.info("Status code  : {}", response.getStatusCode());
		logger.info("Status text  : {}", response.getStatusText());
		logger.info("Headers      : {}", response.getHeaders());
		logger.info("Response body: {}", StreamUtils.copyToString(
				response.getBody(), getCharsetFromHeader(response.getHeaders().getContentType()))
		);
	}

	private Charset getCharsetFromHeader(MediaType mediaType){
		return mediaType != null ? mediaType.getCharset() : StandardCharsets.UTF_8;
	}
}
