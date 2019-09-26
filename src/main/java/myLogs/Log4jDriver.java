package myLogs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDriver {
    private static Logger logger = LogManager.getLogger(Log4jDriver.class);

    public static void main(String[] args) {
        System.out.println("\n Hello World from Log4jDriver...!! \n");
        logger.trace("This is a trace message.");
        logger.debug("This is a debug message.");
        logger.info("This is information message.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");
        logger.fatal("This is a fatal message.");

        System.out.println(" \n Completed");

    }

}
