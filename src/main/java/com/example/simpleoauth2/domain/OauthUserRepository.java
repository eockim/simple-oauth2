package com.example.simpleoauth2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OauthUserRepository extends JpaRepository<OauthUser, Long> {

    OauthUser findByUsername(String username);
}
