/*
 * Copyright (c) JDiscordBots 2019
 * File: NDLogger.java
 * Project: nightdream-logging
 * Licensed under Boost Software License 1.0
 */

package io.github.jdiscordbots.nightdream.logging;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.Attribute;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

public class NDLogger {
	
	private static final String PROP_PREFIX="io.github.jdiscordbots.nightdream.logging.";
	private static Map<String, NDLogger> loggers=new HashMap<>();
	private static ColoredPrinter printer;
	private static boolean timestamp;
	
	private static final LogType DEFAULT_LEVEL;
	
	private String module;
	private LogType loggable;
	
	static {
		LogType level = LogType.INFO;
		String levelProp = System.getProperty(PROP_PREFIX+"Level",level.name()).toUpperCase();
		try{
			level = LogType.valueOf(levelProp);
		}catch (IllegalArgumentException e) {
			//ignore
		}
		DEFAULT_LEVEL=level;
		if(!"false".equalsIgnoreCase(System.getProperty(PROP_PREFIX + "colors"))) {
			printer=new ColoredPrinter.Builder(DEFAULT_LEVEL.getLevel(), false).build();
		}
		timestamp=Boolean.parseBoolean(System.getProperty(PROP_PREFIX+"timestamp","false"));
	}

	/**
	 * @param module name of module
	 */
	private NDLogger(String module) {
		this.module=module;
		String propLevel = System.getProperty(PROP_PREFIX+"Level."+module);
		if(propLevel!=null) {
			try{
				loggable = LogType.valueOf(propLevel);
			}catch (IllegalArgumentException e) {
				//ignore
			}
		}
	}

	/**
	 * @return a logger with no module name (global logger)
	 */
	public static NDLogger getGlobalLogger() {
		return getLogger(null);
	}

	/**
	 * @param module mame of module
	 * @return logger with module
	 */
	public static synchronized NDLogger getLogger(String module) {
		if(!loggers.containsKey(module)) {
			loggers.put(module, new NDLogger(module));
		}
		return loggers.get(module);
	}

	/**
	 * @param message message to log
	 */
	public static void logWithoutModule(String message) {
		getGlobalLogger().log(message);
	}

	/**
	 * @param message message to log
	 * @param throwable {@link Throwable} to log
	 */
	public static void logWithoutModule(String message,Throwable throwable) {
		getGlobalLogger().log(null,message,throwable);
	}

	/**
	 * @param level {@link LogType logtype}
	 * @param message message to log
	 */
	public static void logWithoutModule(LogType level,String message) {
		getGlobalLogger().log(level,message);
	}

	/**
	 * @param level {@link LogType logtype}
	 * @param message message to log
	 * @param throwable {@link Throwable} to log
	 */
	public static void logWithoutModule(LogType level,String message,Throwable throwable) {
		getGlobalLogger().log(level,message,throwable);
	}

	/**
	 * @param module name of module
	 * @param message message to log
	 */
	public static void logWithModule(String module,String message) {
		getLogger(module).log(message);
	}

	/**
	 * @param level {@link LogType logtype}
	 * @param module name of module
	 * @param message message to log
	 */
	public static void logWithModule(LogType level,String module,String message) {
		getLogger(module).log(level,message);
	}

	/**
	 * @param level {@link LogType logtype}
	 * @param module name of module
	 * @param message message to log
	 * @param throwable {@link Throwable} to log
	 */
	public static void logWithModule(LogType level,String module,String message,Throwable throwable) {
		getLogger(module).log(level,message,throwable);
	}

	/**
	 * @param message message to log
	 */
	public void log(String message) {
		log(null,message);
	}

	/**
	 * @param level {@link LogType logtype}
	 * @param message message to log
	 * @param throwable {@link Throwable} to log
	 */
	public void log(LogType level,String message,Throwable throwable) {
		if(isLoggable(level)) {
			if(printer==null) {
				throwable.printStackTrace();
			}else {
				synchronized (System.out) {
					log(level,message);
					throwable.printStackTrace(System.out);
					printer.clear();
				}
			}
		}
	}
	/**
	 * @param level {@link LogType log type}
	 * @param message message to log
	 */
	public void log(LogType level,String message) {
		if(level==null) {
			level=LogType.DEFAULT;
		}
		if(isLoggable(level)) {
			synchronized (System.out) {
				for (String msg : message.split("\n")) {
					if(printer==null) {
						logWithoutColors(level,msg);
					}else {
						logColorful(level,msg);
					}
					System.out.println();
				}
			}
		}
	}
	private void logWithoutColors(LogType level,String message) {
		System.out.print(String.format("%-6s",level.getPrefix())+"| "+message);
		if(module!=null) {
			System.out.print(" | "+module);
		}
		if(timestamp) {
			System.out.println(" | "+getCurrentTime());
		}
	}
	private void logColorful(LogType level,String message) {
		printer.print(String.format("%-6s",level.getPrefix()), Attribute.NONE, level.getfColor(), level.getbColor());
		printer.clear();
		printer.print("| ");
		printer.print(message,Attribute.LIGHT,FColor.NONE,BColor.NONE);
		printer.clear();
		if(module!=null) {
			printer.print(" | ");
			printer.print(module);
		}
		if(timestamp) {
			printer.print(" | ");
			printer.print(getCurrentTime());
		}
	}
	private static String getCurrentTime() {
		return Instant.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzz)"));
	}
	/**
	 * tests if a {@link LogType} will be logged or not
	 * @param level the {@link LogType} to check
	 * @return <code>true</code> if it is loggable
	 */
	public boolean isLoggable(LogType level) {
		if(level==null) {
			return false;
		}
		LogType compare;
		if(loggable==null) {
			compare=DEFAULT_LEVEL;
		}else {
			compare=loggable;
		}
		return level.isHigherOrEqualThan(compare);
	}
	/**
	 * sets the minimum {@link LogType}.<br>
	 * Logs with this LogType or higher will be logged.
	 * @param min the minimum {@link LogType}
	 */
	public void setMinimum(LogType min) {
		loggable=min;
	}
	
	public static void main(String[] args) {
		System.setProperty(PROP_PREFIX+"Level.TEST", "DEBUG");
		logWithModule(LogType.DEBUG, "TEST", ""+LogType.FATAL.isHigherOrEqualThan(LogType.DONE));
	}
	
}
