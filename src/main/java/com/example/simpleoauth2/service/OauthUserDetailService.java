package com.example.simpleoauth2.service;

import com.example.simpleoauth2.domain.OauthUser;
import com.example.simpleoauth2.domain.OauthUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Component
@Service
public class OauthUserDetailService implements UserDetailsService {

    @Autowired
    OauthUserRepository oauthUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName){

        OauthUser oauthUser = oauthUserRepository.findByUserName(userName);
        User.UserBuilder builder = null;

        if(oauthUser == null){
            throw new UsernameNotFoundException(userName);
        }

        builder = User.withUsername(userName);
        builder.password(oauthUser.getPassword());
        builder.roles("USER");

        log.info("username {}", userName);

        return builder.build();
    }


}
