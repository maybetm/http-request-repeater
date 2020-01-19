package com.maybetm.request.http.request.repeater;

import com.maybetm.request.http.request.repeater.http.HTTPTransport;
import com.maybetm.request.http.request.repeater.processor.RequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author zebzeev-sv
 * @version 05.01.2020 22:21
 */
public class Application {

	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String... args) {
		try {
			final long repeatSec = Long.parseLong(args[0]);
			final String url = StringUtils.uriDecode(args[1], StandardCharsets.UTF_8);
			final String payload = StringUtils.uriDecode(args[2], StandardCharsets.UTF_8);

			if (new RequestProcessor(repeatSec, url, payload, new HTTPTransport()).process()) {
				logger.info("process execute is successful");
			} else {
				logger.error("processing is error");
			}
		} catch (Exception ex) {
			logger.error("processing is error", ex);
		}
	}
}
