package io.github.jdiscordbots.nightdream.logging.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import io.github.jdiscordbots.nightdream.logging.NDLogger;

public class NDSLF4JLoggerFactory implements ILoggerFactory{

	@Override
	public Logger getLogger(String name) {
		return new NDSLF4JLogger(name==null?NDLogger.getGlobalLogger():NDLogger.getLogger(name));
	}
 }
