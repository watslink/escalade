package com.sd.oc.Service;

import com.sd.oc.DAO.ConfigurationDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.sd.oc.Service")
@Import(ConfigurationDAO.class)
public class ConfigurationService {
}
