package oving8;

public class DistributingLogger implements ILogger{
	
	ILogger errorLogger, warningLogger, infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger){
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}
	
	public void setLogger(String severity, ILogger logger){
		if (severity == ILogger.ERROR){
			this.errorLogger = logger;
		}
		else if (severity == ILogger.INFO){
			this.infoLogger = logger;
		}
		else if (severity == ILogger.WARNING){
			this.warningLogger = logger;
		}
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if (severity == ILogger.ERROR){
			errorLogger.log(severity, message, exception);
		}
		else if (severity == ILogger.INFO){
			infoLogger.log(severity, message, exception);
		}
		else if (severity == ILogger.WARNING){
			warningLogger.log(severity, message, exception);
		}
		
	}

}
