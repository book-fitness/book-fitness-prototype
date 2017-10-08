package ru.tiger.bookprototype.servlet.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * Thanks
 * https://github.com/jtalks-org/poulpe/blob/a9b1d5211e0ba9d0ed4a7293b5870905018b2607/poulpe-view/poulpe-web-controller/src/main/java/org/jtalks/poulpe/web/controller/JdbcDriverUnregisteringListener.java
 */
public class JdbcDriverUnregisteringListener implements ServletContextListener {
    private Logger logger;

    @Override
    public void contextInitialized(ServletContextEvent event) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger = Logger.getLogger(getClass());
        deregisterDrivers(getDrivers());
    }

    Enumeration<Driver> getDrivers() {
        return DriverManager.getDrivers();
    }

    void deregisterDrivers(Enumeration<Driver> drivers) {
        while (drivers.hasMoreElements()) {
            deregisterDriver(drivers.nextElement());
        }
    }

    void deregisterDriver(Driver driver) {
        try {
            DriverManager.deregisterDriver(driver);
            logger.info("Deregistering JDBC driver: " + driver);
        } catch (SQLException e) {
            logger.warn("Error deregistering JDBC driver: "+driver+". Root cause: " + e);
        }
    }
}
