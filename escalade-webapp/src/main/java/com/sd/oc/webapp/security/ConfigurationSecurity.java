package com.sd.oc.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {


   private final DataSource dataSource;

    @Autowired
    public ConfigurationSecurity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource).usersByUsernameQuery(
                "select pseudo, mot_de_passe, enabled from utilisateur where pseudo=?")
                .authoritiesByUsernameQuery(
                        "select pseudo, role from utilisateur where pseudo=?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**","/webjars/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()

                .and()
                .logout().deleteCookies("JSESSIONID")

                .and()
                .rememberMe().key("uniqueAndSecret")
                ;
    }
}