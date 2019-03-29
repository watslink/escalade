package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.SecteurDAO;
import com.sd.oc.DAO.DAOInterface.TopoDAO;
import com.sd.oc.DAO.DAOInterface.UtilisateurDAO;
import com.sd.oc.model.Secteur;
import com.sd.oc.model.Topo;
import com.sd.oc.model.Utilisateur;
import com.sd.oc.model.Voie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Set;

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

        Secteur secteur=secteurDAO.find(2);

        Set<Voie> listVoie=secteur.getListVoie();
        System.out.println(listVoie);

            for (Voie voie: secteur.getListVoie()) {
                System.out.println(voie.getNom());
            }

        UtilisateurDAO utilisateurDAO=context.getBean(UtilisateurDAO.class);

            utilisateurDAO.create(new Utilisateur("Robert","robert@gmail.com","motdepasse" ));

    }
}
