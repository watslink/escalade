package com.sd.oc.DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProperties {

    private final String driverClassName;

    private final String url;

    private final String username;

    private final String password;

    public DatabaseProperties(@Value("${driverClassName}") final String driverClassName,
                              @Value("${url}") final String url, @Value("${username}") final String username,
                              @Value("${password}") final String password) {
        super();
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
