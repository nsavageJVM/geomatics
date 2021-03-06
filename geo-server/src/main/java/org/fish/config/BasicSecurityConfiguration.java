package org.fish.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by ubu on 26.05.17.
 */
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers(  "/gis/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/boot/login").defaultSuccessUrl("/boot").permitAll()
                .and() .logout() .logoutUrl("/boot/logout").logoutSuccessUrl("/boot/login")
                .permitAll()
                .and().exceptionHandling() //exception handling configuration
                .accessDeniedPage("/boot/error");

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");;
    }


}
