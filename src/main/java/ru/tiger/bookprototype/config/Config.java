package ru.tiger.bookprototype.config;

/**
 *
 * @author Tiger
 */
public class Config {
    public static final String LOGGER_NAME = "BookPrototype";
    public static final int DEFAULT_SERVER_PORT = 8080;
    
    public static int getPort() {
        int port = DEFAULT_SERVER_PORT;
        
        try {
            port = Integer.parseInt(System.getenv("PORT")); // From Heroku ENV.
            System.out.println("Use port from ENV: " + port);
        } catch (NumberFormatException e) {
            System.out.println(e);
            //e.printStackTrace();
            System.out.println("Use default port: " + port);
        }
        
        return port;
    }
}
