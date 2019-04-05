package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.SiteDAO;
import com.sd.oc.model.Site;
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



        SiteDAO siteDAO=context.getBean(SiteDAO.class);


    }
}
