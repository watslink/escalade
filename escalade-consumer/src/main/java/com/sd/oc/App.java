package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.SecteurDAO;
import com.sd.oc.DAO.DAOInterface.TopoDAO;
import com.sd.oc.model.Secteur;
import com.sd.oc.model.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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



        SecteurDAO secteurDAO=context.getBean(SecteurDAO.class);

        List<Secteur> listSecteur=secteurDAO.findAll();


        for (Secteur secteur :listSecteur) {
            System.out.println(secteur.getNom());
        }

    }
}
