/*
 * Copyright (c) JDiscordBots 2019
 * File: LogType.java
 * Project: nightdream-logging
 * Licensed under Boost Software License 1.0
 */

package io.github.jdiscordbots.nightdream.logging;

import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

public enum LogType {
	LOG(80,FColor.WHITE),
	WARN(40,FColor.YELLOW),
	QUESTION(50,FColor.MAGENTA,"?????"),
	INFO(60,FColor.BLUE),
	DONE(60,FColor.GREEN),
	ERROR(30,FColor.RED),
	FATAL(20,FColor.RED),//rainbow???
	DEBUG(90,FColor.CYAN),
	ARROW(60,FColor.RED,BColor.WHITE,">>>>>"),
	DEFAULT(60,FColor.WHITE,BColor.CYAN,"====>");
	
	private String prefix;
	private int level;
	private BColor bColor;
	private FColor fColor;
	
	private LogType(int level,FColor fColor) {
		this(level,fColor,BColor.NONE,null);
		prefix=name();
	}
	private LogType(int level,FColor fColor,String name) {
		this(level,fColor,BColor.NONE,name);
	}
	private LogType(int level,FColor fColor,BColor bColor,String name) {
		this.prefix=name;
		this.level=level;
		this.fColor=fColor;
		this.bColor=bColor;
	}
	/**
	 * gets the prefix of this {@link LogType} (before |)
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * gets the severity of this {@link LogType}<br>
	 * Lower means more severe.
	 * @return the severity(level) as integer
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * gets the background color as JCDP {@link BColor}
	 * @return the background color
	 */
	public BColor getbColor() {
		return bColor;
	}
	/**
	 * gets the foreground color as JCDP {@link FColor}
	 * @return the foreground color
	 */
	public FColor getfColor() {
		return fColor;
	}
	/**
	 * tests if this logType is logged if a given {@link LogType} is the default level.
	 * @param type the given {@link LogType} (default level)
	 * @return <code>true</code> if this {@link LogType} would be logged.
	 */
	public boolean isHigherOrEqualThan(LogType type) {
		return level<=type.level;
	}
}
