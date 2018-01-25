package oving8;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger{
	
	private OutputStream stream;
	private String formatString;
	
	public StreamLogger(OutputStream stream){
		this.stream = stream;
		formatString =  "%s: %s (%s)";
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if (stream == null){
			throw new NullPointerException("Stream ikke satt");
		}
		String logMessage = String.format(formatString, severity, message, exception);
		PrintWriter writer = new PrintWriter(stream);
		writer.write(logMessage);
		writer.flush();
		writer.close();
		
	}
	
	public void setFormatString(String formatString){
		this.formatString = formatString;
	}

}
