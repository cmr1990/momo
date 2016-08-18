package org.momo.automation.log;

public class Logger {

	public static void info(String message) {
		Log4jReader.getLog4j().info(message);
	}

	public static void debug(String message) {
		Log4jReader.getLog4j().debug(message);
	}

	public static void error(String message) {
		Log4jReader.getLog4j().error(message);
	}

	public static void fatal(String message) {
		Log4jReader.getLog4j().fatal(message);
	}

	public static void warn(String message) {
		Log4jReader.getLog4j().warn(message);
	}

}
