package com.company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Properties;

/**
 * Created by Developer on 1/7/17.
 */
public class GrizzlyHelper {
    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/student11");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "root");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            prop.setProperty("hibernate.hbm2ddl.auto", "update");

            concreteSessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(prop)
                    //.addPackage("com.kat")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory()
            ;
                    }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }

}




