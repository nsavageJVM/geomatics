package org.fish.config;

import org.fish.controller.ErrController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by ubu on 28.05.17.
 */
@Configuration
@Import(BasicSecurityConfiguration.class)
public class BasicConfig {

    @Autowired
    private ErrorAttributes errorAttributes;


    @Bean
    public ErrController errController(){return new ErrController(errorAttributes);}
}
