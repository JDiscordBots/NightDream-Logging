# NightDream Logging 
[![Build Status](https://travis-ci.com/JDiscordBots/NightDream-Logging.svg?branch=master)](https://travis-ci.com/JDiscordBots/NightDream-Logging)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=JDiscordBots_NightDream-Logging&metric=alert_status)](https://sonarcloud.io/dashboard?id=JDiscordBots_NightDream-Logging)

a simple, colorful Logging Library

## use Nightdream Logging standalone
* Add Nightdream Logging to the dependencies section of your `pom.xml` (replace VERSION with [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.jdiscordbots/nightdream-logging/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.jdiscordbots/nightdream-logging)):
```xml
<dependencies>
	<dependency>
		<groupId>io.github.jdiscordbots</groupId>
		<artifactId>nightdream-logging</artifactId>
		<version>VERSION</version>
		<scope>compile</scope>
	</dependency>
</dependencies>
```

# Limitations
NightDream-Logging does **not** support coloring on Windows versions lower than *10*.

This is because older windows versions do not support native ANSI escape codes.

NightDream-Logging will just display the Logs without colering in those versions.

## use Nightdream Logging with SLF4J
* Add Nightdream Logging and slf4j-api to the dependencies section of your `pom.xml` (replace NDL-VERSION with 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.jdiscordbots/nightdream-logging/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.jdiscordbots/nightdream-logging)
and SLF4J-VERSION with
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.slf4j/slf4j-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.slf4j/slf4j-api)
):
```xml
<dependencies>
	<dependency>
		<groupId>io.github.jdiscordbots</groupId>
		<artifactId>nightdream-logging</artifactId>
		<version>NDL-VERSION</version>
		<scope>compile</scope>
	</dependency>
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-api</artifactId>
		<version>SLF4J-VERSION</version>
	</dependency>
</dependencies>
```