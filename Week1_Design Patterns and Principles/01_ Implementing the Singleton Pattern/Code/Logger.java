public class Logger {
    private static final Logger singleInstance = new Logger();
    private Logger() {
        System.out.println("Logger instance created.");
    }
    public static Logger getInstance() {
        return singleInstance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
