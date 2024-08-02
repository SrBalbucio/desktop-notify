package ds.desktop.notify;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import static ds.desktop.notify.DesktopNotify.*;

public class DSLogger {


    // Integrated Logging
    public static final int DEBUG = 0;
    public static final int NONE = 10;

    /**
     * Allows to specify the level allowed for logging messages. Attempts to log
     * messages with a priority level below what's been set will be ignored.
     *
     * @param level The logging priority level to allow as minimum.
     */
    public static void setLogLevel(int level) {
        logger.setLoggingLevel(level);
    }

    /**
     * Returns the level allowed for logging messages. Attempts to log
     * messages with a priority level below what's been set will be ignored.
     *
     * @return The logging priority level curently allowed as minimum.
     */
    public static int getLogLevel() {
        return logger.getLoggingLevel();
    }

    public static void setLogOutput(OutputStream outStream) {
        logger.setOutput(outStream);
    }

    /**
     * Logs a debug message. Parameters can't be {@code null}.
     *
     * @param tag     The tag associated to this message.
     * @param message The message to include.
     */
    public static void logDebug(String tag, String message) {
        logger.post(DEBUG, tag, message, null);
    }

    /**
     * Logs an information message. Parameters can't be {@code null}.
     *
     * @param tag     The tag associated to this message.
     * @param message The message to include.
     */
    public static void logInfo(String tag, String message) {
        logger.post(INFORMATION, tag, message, null);
    }

    /**
     * Logs a warning message. Parameters can't be {@code null}.
     *
     * @param tag     The tag associated to this message.
     * @param message The message to include.
     */
    public static void logWarning(String tag, String message) {
        logger.post(WARNING, tag, message, null);
    }

    /**
     * Logs an error message. Parameters other than the caught throwable can't
     * be {@code null}.
     *
     * @param tag     The tag associated to this message.
     * @param message The message to include.
     * @param tr      A Throable object (an Exception, for example), whose
     *                message and stack trace should be logged too.
     */
    public static void logError(String tag, String message, Throwable tr) {
        logger.post(ERROR, tag, message, tr);
    }

    private static final DSLogger logger = new DSLogger();

    private OutputStream outStream;
    private PrintWriter outWritter;

    private int level;

    void Logger() {
        this.level = INFORMATION;
        this.setOutput(System.out);
    }

    /**
     * Lets you specify an OutputStream for use in this Logger.
     *
     * @param outStream The OutputStream you wish to log messages into.
     */
    public synchronized void setOutput(OutputStream outStream) {
        this.outStream = outStream;
        this.outWritter = new PrintWriter(outStream);
    }

    /**
     * @return <code>true</code> if a proper output destiny has been set, like
     * an output file or stream.
     */
    public boolean isReady() {
        return outWritter != null;
    }

    private String levelToString(int level) {
        String str = "OTHER";
        switch (level) {
            case DEBUG:
                str = "DEBUG";
                break;
            case INFORMATION:
                str = "INFO";
                break;
            case WARNING:
                str = "WARNING";
                break;
            case ERROR:
                str = "ERROR";
                break;
        }
        return str;
    }

    public synchronized void setLoggingLevel(int level) {
        this.level = level;
    }

    public synchronized int getLoggingLevel() {
        return this.level;
    }

    /**
     * Checks for you if a given level is enabled in this logger.
     *
     * @param level The level to check.
     * @return <code>true</code> if the given level is found to be enabled,
     * <code>false</code> otherwise.
     */
    public boolean isEnabled(int level) {
        return this.level <= level;
    }

    /**
     * Full form of the method. This method lets you post a message into this
     * logger, so it can be logged or not depending of the assigned settings.
     * You can specify a title (tag), message, flag and a Throwable object (like
     * an Exception or Error) to include in the log.
     *
     * @param level   The level to mark this message with.
     * @param tag     The tag associated to this message. It cannot be null.
     * @param message The message to include. It cannot be null.
     * @param tr      A Throwable whose message and stack trace should be
     *                printed.
     */
    public synchronized void post(int level, String tag, String message, Throwable tr) {
        if (tag == null) throw new NullPointerException("Tag please");
        if (message == null) throw new NullPointerException("Message please");
        if (isReady() && isEnabled(level)) {
            StringBuilder builder = new StringBuilder();
            builder.append(levelToString(level)).append(":").append(tag)
                    .append(" at [").append(new java.util.Date())
                    .append("] -> ").append(message.trim());
            if (outStream instanceof PrintStream) {
                ((PrintStream) outStream).println(builder);
            } else {
                outWritter.println(builder);
                outWritter.flush();
            }
            if (tr != null) {
                if (outStream instanceof PrintStream) {
                    ((PrintStream) outStream).println("Caused by:");
                    tr.printStackTrace((PrintStream) outStream);
                } else {
                    outWritter.println("Caused by:");
                    tr.printStackTrace(outWritter);
                    outWritter.flush();
                }
            }
        }
    }
}
