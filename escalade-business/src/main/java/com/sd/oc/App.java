package com.sd.oc;

import com.sd.oc.Service.ConfigurationService;
import com.sd.oc.Service.ServiceInterface.TopoService;
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

        TopoService topoService=context.getBean(TopoService.class);

        Topo topo=topoService.get(7);



        System.out.println(topo.getDescription());
    }
}
