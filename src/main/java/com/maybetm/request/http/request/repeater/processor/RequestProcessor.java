package com.maybetm.request.http.request.repeater.processor;

import com.maybetm.request.http.request.repeater.http.IHTTPTransport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;

/**
 * @author zebzeev-sv
 * @version 06.01.2020 16:08
 */
public class RequestProcessor implements IProcessor{

	private final Logger logger = LogManager.getLogger(this.getClass());

	private final long repeatSec;
	private final String url;
	private final String payload;
	private final IHTTPTransport httpTransport;

	public RequestProcessor(long repeatSecond, String url, String payload, IHTTPTransport httpTransport) {
		this.repeatSec = repeatSecond;
		this.url = url;
		this.payload = payload;
		this.httpTransport = httpTransport;
	}

	@Override
	public boolean process(){

		Instant begin = Instant.now();
		Instant end = begin.plusSeconds(repeatSec);

		int inc = 0;
		while (Instant.now().getEpochSecond() < end.getEpochSecond()) {
			httpTransport.request(url, payload);
			inc++;
		}

		logger.info("begin: {}; end: {}; count: {};", begin, end, inc);
		return true;
	}

}
