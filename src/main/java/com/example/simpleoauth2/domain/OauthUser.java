package com.example.simpleoauth2.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OauthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
}
