package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.LongueurDAO;
import com.sd.oc.DAO.DAOInterface.VoieDAO;
import com.sd.oc.model.Longueur;
import com.sd.oc.model.Voie;
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



        VoieDAO voieDAO=context.getBean(VoieDAO.class);

       Voie voie= voieDAO.find(8);



        System.out.println(voie.getListLongueur().get(1).getDescription());
    }
}
