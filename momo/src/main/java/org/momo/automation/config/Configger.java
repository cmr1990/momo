package org.momo.automation.config;

import java.util.HashMap;
import java.util.Map;


public class Configger {

	private Map<String, String> config = new HashMap<String, String>();
	
	private Configger instance = null;
	
	private Configger(){
		
	}

	public String getValue(String key) throws NoSuchConfigValueException {
		String value = config.get(key);
		String errorMsg = "Cannot find the value of the key: " + key + " in the config file";
		if (value != null)
			return value;
		else
			throw new NoSuchConfigValueException(errorMsg);
	}

}
