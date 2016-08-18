package org.momo.automation.log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.momo.automation.utils.DateUtils;

public class Log4jReader {

	private org.apache.log4j.Logger log4j = null;
	private final String Log4j_Configuration_Path = "configuration/log4j.properties";
	private static Log4jReader instance = null;

	private Log4jReader() {

	}

	public static Log4jReader getLog4jReader() {
		if (Log4jReader.instance == null)
			return new Log4jReader();
		else
			return Log4jReader.instance;
	}

	public org.apache.log4j.Logger getLog4j() {
		if (this.log4j == null) {
			PropertyConfigurator.configure(readConfig());
			this.log4j = org.apache.log4j.Logger.getLogger(Log4jReader.class);
		}
		return this.log4j;
	}

	private Properties readConfig() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(this.Log4j_Configuration_Path));
			prop.setProperty(this.getPropertiesFileKey(prop), "logs/" + DateUtils.getTime("yyyy-MM-dd") + ".log");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	private String getPropertiesFileKey(Properties prop) {
		Set<Object> keys = prop.keySet();
		Iterator<Object> it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.endsWith("File") && key.startsWith("log4j")) {
				return key;
			}
		}
		return null;
	}
}
