package ru.tiger.bookprototype.servlet.listener;

//import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.tiger.bookprototype.config.Config;

/**
 * Web application lifecycle listener.
 *
 * @author Tiger
 */
public class BPContextListener implements ServletContextListener {
    
    private Logger logger;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger = LogManager.getLogger(Config.LOGGER_NAME);
        
        logger.info("<<<< Start servlet context...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("<<<< Finish servlet context...");
        //System.out.println("Try stopped MySQL AbandonedConnectionCleanupThread");
        //AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
