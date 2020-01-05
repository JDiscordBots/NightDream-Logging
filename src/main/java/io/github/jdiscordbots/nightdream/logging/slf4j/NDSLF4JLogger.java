package io.github.jdiscordbots.nightdream.logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.Marker;

import io.github.jdiscordbots.nightdream.logging.LogType;
import io.github.jdiscordbots.nightdream.logging.NDLogger;

class NDSLF4JLogger implements Logger{
	
	private NDLogger logger;
	
	public NDSLF4JLogger(NDLogger logger) {
		this.logger=logger;
	}

	@Override
	public String getName() {
		return logger.getModule();
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isLoggable(LogType.LOG);
	}

	@Override
	public void trace(String msg) {
		logger.log(LogType.LOG, msg);
	}

	@Override
	public void trace(String format, Object arg) {
		if(isTraceEnabled()) {
			trace(String.format(format, arg));
		}
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		if(isTraceEnabled()) {
			trace(String.format(format, arg1,arg2));
		}
	}

	@Override
	public void trace(String format, Object... arguments) {
		if(isTraceEnabled()) {
			trace(String.format(format, arguments));
		}
	}

	@Override
	public void trace(String msg, Throwable t) {
		logger.log(LogType.LOG,msg,t);
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return isTraceEnabled();
	}

	@Override
	public void trace(Marker marker, String msg) {
		trace(msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		trace(format,arg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		trace(format,arg1,arg2);
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		trace(format,argArray);
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		trace(msg,t);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isLoggable(LogType.DEBUG);
	}

	@Override
	public void debug(String msg) {
		logger.log(LogType.DEBUG,msg);
	}

	@Override
	public void debug(String format, Object arg) {
		if(isDebugEnabled()) {
			debug(String.format(format, arg));
		}
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		if(isDebugEnabled()) {
			debug(String.format(format, arg1,arg2));
		}
	}

	@Override
	public void debug(String format, Object... arguments) {
		if(isDebugEnabled()) {
			debug(String.format(format, arguments));
		}
	}

	@Override
	public void debug(String msg, Throwable t) {
		logger.log(LogType.DEBUG, msg,t);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return isDebugEnabled();
	}

	@Override
	public void debug(Marker marker, String msg) {
		debug(msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		debug(format,arg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		debug(format,arg1,arg2);
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		debug(format,arguments);
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		debug(msg,t);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isLoggable(LogType.INFO);
	}

	@Override
	public void info(String msg) {
		logger.log(LogType.INFO,msg);
	}

	@Override
	public void info(String format, Object arg) {
		if(isInfoEnabled()) {
			info(String.format(format, arg));
		}
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		if(isInfoEnabled()) {
			info(String.format(format, arg1,arg2));
		}
	}

	@Override
	public void info(String format, Object... arguments) {
		if(isInfoEnabled()) {
			info(String.format(format, arguments));
		}
	}

	@Override
	public void info(String msg, Throwable t) {
		logger.log(LogType.INFO,msg,t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return isInfoEnabled();
	}

	@Override
	public void info(Marker marker, String msg) {
		info(msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		info(format,arg);
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		info(format,arg1,arg2);
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		info(format,arguments);
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		info(msg,t);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isLoggable(LogType.WARN);
	}

	@Override
	public void warn(String msg) {
		logger.log(LogType.WARN, msg);
	}

	@Override
	public void warn(String format, Object arg) {
		if(isWarnEnabled()) {
			warn(String.format(format, arg));
		}
	}

	@Override
	public void warn(String format, Object... arguments) {
		if(isWarnEnabled()) {
			warn(String.format(format, arguments));
		}
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		if(isWarnEnabled()) {
			warn(String.format(format, arg1,arg2));
		}
	}

	@Override
	public void warn(String msg, Throwable t) {
		logger.log(LogType.WARN,msg,t);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return isWarnEnabled();
	}

	@Override
	public void warn(Marker marker, String msg) {
		warn(msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		warn(format,arg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		warn(format,arg1,arg2);
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		warn(format,arguments);
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		warn(msg,t);
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isLoggable(LogType.ERROR);
	}

	@Override
	public void error(String msg) {
		logger.log(LogType.ERROR,msg);
	}

	@Override
	public void error(String format, Object arg) {
		if(isErrorEnabled()) {
			error(String.format(format, arg));
		}
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		if(isErrorEnabled()) {
			error(String.format(format, arg1,arg2));
		}
	}

	@Override
	public void error(String format, Object... arguments) {
		if(isErrorEnabled()) {
			error(String.format(format, arguments));
		}
	}

	@Override
	public void error(String msg, Throwable t) {
		logger.log(LogType.ERROR,msg,t);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return isErrorEnabled();
	}

	@Override
	public void error(Marker marker, String msg) {
		error(msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		error(format,arg);
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		error(format,arg1,arg2);
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		error(format,arguments);
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		error(msg,t);
	}
}
