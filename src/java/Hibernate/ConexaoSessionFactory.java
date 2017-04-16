package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class ConexaoSessionFactory {
	
	private static SessionFactory sf = null;
   
    public static SessionFactory getSessionFactory() {
           	
    	if (sf == null) {
    		sf = new AnnotationConfiguration().configure().buildSessionFactory();
    	}
    	
    	return sf;    
    }    
    
}
