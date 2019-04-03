package com.sd.oc;

import com.sd.oc.Service.ConfigurationService;
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







    }
}
