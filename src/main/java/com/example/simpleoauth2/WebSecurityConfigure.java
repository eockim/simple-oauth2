package com.example.simpleoauth2;

import com.example.simpleoauth2.service.OauthUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {


    @Autowired
    OauthUserDetailService oauthUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}test")
//                .roles("USER")
//                    .and()
//                .withUser("user2")
//                .password("{noop}test")
//                .roles("ADMIN");
        auth.authenticationProvider(authenticationProvider());
       // auth.userDetailsService(oauthUserDetailService).passwordEncoder(encoder());

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(oauthUserDetailService);
        authProvider.setPasswordEncoder(encoder());

        log.info("encoder {}", encoder().encode("test"));
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new OauthUserDetailService();
    };

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
