package org.momo.ui.log;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LogFileWriter implements Runnable {
	
	private ConcurrentLinkedDeque logs = null;
	
	public LogFileWriter(String logPath){
		this.logs = new ConcurrentLinkedDeque();
		
	}
	
	private void createLogFile(String filePath, String fileName){
	}
	
	public void run(){
		
	}

}
