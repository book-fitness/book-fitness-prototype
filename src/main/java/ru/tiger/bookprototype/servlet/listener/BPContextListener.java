package ru.tiger.bookprototype.servlet.listener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Tiger
 */
public class BPContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Start servlet context...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Finish servlet context...");
        System.out.println("Try stopped MySQL AbandonedConnectionCleanupThread");
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
