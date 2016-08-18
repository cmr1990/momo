package org.momo.automation.config;

import org.momo.automation.log.Logger;

public class NoSuchConfigValueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchConfigValueException(String msg){
		super(msg);
		Logger.error(msg);
	}

}
