package ru.tiger.bookprototype.loging;

import org.apache.logging.log4j.Logger;

/**
 *
 * @author Igor
 */
public class LoggerObject {
    public static Logger logger;
    
    public static void setLogger(String className) {
        logger = (Logger) java.util.logging.Logger.getLogger(className);
    }
    
    public void setLogging(String message) {
        logger.info(message);
    }
}
