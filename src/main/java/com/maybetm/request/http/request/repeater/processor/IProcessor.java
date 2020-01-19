package com.maybetm.request.http.request.repeater.processor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author zebzeev-sv
 * @version 06.01.2020 16:12
 */
public interface IProcessor {

	public boolean process() throws InterruptedException, ExecutionException, TimeoutException;
}
