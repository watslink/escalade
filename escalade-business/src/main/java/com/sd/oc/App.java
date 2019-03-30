package com.sd.oc;

import com.sd.oc.Service.ConfigurationService;
import com.sd.oc.Service.ServiceInterface.TopoService;
import com.sd.oc.Service.ServiceInterface.UtilisateurService;
import com.sd.oc.model.Topo;
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
        System.out.println( "Hello World!" );

        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationService.class);

        UtilisateurService utilisateurService=context.getBean(UtilisateurService.class);


        ;


        System.out.println(utilisateurService.getByPseudo("Robert").getMail());
    }
}
