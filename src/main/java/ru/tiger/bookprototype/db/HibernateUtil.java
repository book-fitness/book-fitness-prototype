package ru.tiger.bookprototype.db;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Deprecated
public class HibernateUtil {
    private static SessionFactory factory;
    
    public synchronized static Session getSession() {
        if (factory == null) {
            init();
        }
        return factory.openSession();
    }
    
    private static void init() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
            //factory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e); // todo: chage to logging
        }
    }
    
    public synchronized boolean isReady() {
        return factory != null;
    }
}
