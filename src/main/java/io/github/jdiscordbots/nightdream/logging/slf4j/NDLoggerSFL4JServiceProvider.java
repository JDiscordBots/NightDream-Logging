package io.github.jdiscordbots.nightdream.logging.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class NDLoggerSFL4JServiceProvider implements SLF4JServiceProvider{

	private ILoggerFactory loggerFactory;
	private IMarkerFactory markerFactory;
	private MDCAdapter mdcAdapter;
	@Override
	public ILoggerFactory getLoggerFactory() {
		return loggerFactory;
	}

	@Override
	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	@Override
	public MDCAdapter getMDCAdapter() {
		return mdcAdapter;
	}

	@Override
	public String getRequesteApiVersion() {
		return "1.8.99";
	}

	@Override
	public void initialize() {
		loggerFactory=new NDSLF4JLoggerFactory();
		markerFactory=new BasicMarkerFactory();
		mdcAdapter=new NOPMDCAdapter();
	}

}
