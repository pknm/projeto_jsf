

package com.mycompany.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




public class HibernateUtil {
   
    private static final SessionFactory sessionFactory;
    public  static String HIBERNATE_SESSION = "hibernate_session";
    
    static {
    
        try {
            System.out.println(" Tentando configurar a sessionFactory");
            
            Configuration configuration = new Configuration().configure();
         
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
         
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println(" TUDO OCORREU BEM, SESSIONFACTORY CRIADA COM SUCESSO");
           
        } catch (Exception ex) {
            System.out.println("Ocorreu um error ao iniciar a session factory"+ ex);
            throw  new ExceptionInInitializerError(ex);
            
            
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    
}
