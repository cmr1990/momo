package org.momo.automation.log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.momo.utils.DateUtils;

public class Log4jReader {

	private static org.apache.log4j.Logger log4j = null;
	private final static String Log4j_Configuration_Path = "configuration/log4j.properties";

	public static org.apache.log4j.Logger getLog4j() {
		if (Log4jReader.log4j == null) {
			PropertyConfigurator.configure(readConfig());
			Log4jReader.log4j = org.apache.log4j.Logger.getLogger(Log4jReader.class);
		}
		return Log4jReader.log4j;
	}

	private static Properties readConfig() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(Log4jReader.Log4j_Configuration_Path));
			prop.setProperty("log4j.appender.D.File", "logs/" + DateUtils.getTime("yyyy-MM-dd") + ".log");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
