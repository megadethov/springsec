package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * Default configurations which will secure all the requests
         */

/*
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();
*/


        /**
         * Custom configurations as per our requirement
         *      /my-account - Secured
         *      /my-balance - Secured
         *      /my-loans - Secured
         *      /my-cards - Secured
         *      /notices - Not Secured
         *      /contact - Not Secured
         */
        http.authorizeRequests()
                .antMatchers("/my-account").authenticated()
                .antMatchers("/my-balance").authenticated()
                .antMatchers("/my-loans").authenticated()
                .antMatchers("/my-cards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and().formLogin()
                .and().httpBasic();

    }

}
