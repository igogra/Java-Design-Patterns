package behavioral.chainofresponsibility;

abstract class Logger {
	public static int OUTPUTINFO = 1;
	public static int ERRORINFO = 2;
	public static int DEBUGINFO = 3;
	protected int threshold;
	protected Logger nextLogger;

	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(String msg, int priority) {
		if (threshold <= priority) {
			writeMessage(msg);
		}

		if (nextLogger != null) {
			nextLogger.logMessage(msg, priority);
		}
	}

	protected abstract void writeMessage(String msg);
}

class ConsoleLogger extends Logger {
	public ConsoleLogger(int threshold) {
		this.threshold = threshold;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Console logger: " + msg);
	}
}

class DebugLogger extends Logger {
	public DebugLogger(int threshold) {
		this.threshold = threshold;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Debug logger: " + msg);
	}
}

class ErrorLogger extends Logger {
	public ErrorLogger(int threshold) {
		this.threshold = threshold;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Error logger: " + msg);
	}
}

public class DemoChainOfResponsibility {
	private static Logger createChain() {
		Logger consoleLogger = new ConsoleLogger(Logger.OUTPUTINFO);

		Logger errorLogger = new ErrorLogger(Logger.ERRORINFO);
		consoleLogger.setNextLogger(errorLogger);

		Logger debugLogger = new DebugLogger(Logger.DEBUGINFO);
		errorLogger.setNextLogger(debugLogger);

		return consoleLogger;
	}

	public static void main(String[] args) {
		Logger chainLogger = createChain();

		chainLogger.logMessage("Console...", Logger.OUTPUTINFO);
		chainLogger.logMessage("Error...", Logger.ERRORINFO);
		chainLogger.logMessage("Debug...", Logger.DEBUGINFO);
	}
}
