package com.example.simpleoauth2;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "cmi";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .requestMatchers()
//                .antMatchers("/login")
//                .and()
                .authorizeRequests()
                .antMatchers("/test/**")
                .access("#oauth2.hasScope('read')");
//                .anyRequest()
//                .access("#oauth2.hasScope('read')");
//        http.authorizeRequests()
//                .antMatchers("/login")
//                .permitAll()
//                    .and()
//                .authorizeRequests()
//                .anyRequest()
//                .access("#oauth2.hasScope('read')");
//                //.permitAll();

    }
}
