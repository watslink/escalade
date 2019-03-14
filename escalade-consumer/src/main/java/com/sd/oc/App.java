package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.model.Longueur;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(
                "Hello World!" );

        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationDAO.class);

        Longueur longeurnew= new Longueur("ahahah","3c", 1,40,1);

        LongueurDAO longueurDAO=context.getBean(LongueurDAO.class);

        longueurDAO.create(longeurnew);

        Longueur longueur=longueurDAO.find(1);

        System.out.println(longueur.getDescription());
    }
}
