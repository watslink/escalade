package com.sd.oc;

import com.sd.oc.DAO.ConfigurationDAO;
import com.sd.oc.DAO.DAOInterface.TopoDAO;
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
        System.out.println(
                "Hello World!" );

        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationDAO.class);



        TopoDAO topoDAO=context.getBean(TopoDAO.class);

        Topo topo=topoDAO.find(7);



        System.out.println(topo.getDescription());
    }
}
