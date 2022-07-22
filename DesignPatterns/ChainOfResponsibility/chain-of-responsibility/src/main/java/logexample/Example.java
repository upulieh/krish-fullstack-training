package logexample;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {
	
	public void myMethod() {
		Logger logger=Logger.getLogger(Example.class.getName());
		logger.setLevel(Level.INFO);
		
		logger.log(Level.INFO,"this is info");
		logger.log(Level.WARNING,"this is warning");
		logger.log(Level.FINE,"this is fine"); //this is skipped as the current level is INFO
		logger.log(Level.SEVERE,"this is severe");
	}
}
