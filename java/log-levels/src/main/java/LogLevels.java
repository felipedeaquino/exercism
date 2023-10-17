public class LogLevels {
    
    public static String message(String logLine) {
        int colonIndex = logLine.indexOf(":");
        return logLine.substring(colonIndex + 1).trim();
    };

    public static String logLevel(String logLine) {
        int startIndex = logLine.indexOf("[");
        int endIndex = logLine.indexOf("]");
        return logLine.substring(startIndex + 1, endIndex).toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String logLevel = logLevel(logLine);
        return String.format("%s (%s)", message, logLevel);
    }
}
