package oving8;

import java.util.ArrayList;
import java.util.List;

public class FilteringLogger implements ILogger{
	List<String> severi;
	ILogger logger;
	
	public FilteringLogger(ILogger logger, String...severities){
		severi = new ArrayList<>();
		for (int i=0; i<severities.length; i++){
			severi.add(severities[i]);
		}
		this.logger = logger;
		
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if (logger == null){
			throw new NullPointerException("Logger ikke satt");
		}
		if (severi.contains(severity)){
			logger.log(severity, message, exception);
		}
	}
	
	public boolean isLogging(String severity){
		if (severi.contains(severity)){
			return true;
		}
		return false;
	}
	
	public void setIsLogging(String severity, boolean value){
		if (severi.contains(severity) && !value){
			severi.remove(severity);
		}
		else if(!severi.contains(severity) && value){
			severi.add(severity);
		}
		
	}
	

}
