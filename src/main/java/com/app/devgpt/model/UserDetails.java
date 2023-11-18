package com.app.devgpt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String mobile;
    private String name;
    private String password;
    private String role;
    private String username;
    private String openaiApiKey;
    private String openaiApiSecret;
    private String openaiOrganization;
    private String openaiModel;
    private String openaiTemperature;
    private String openaiMaxTokens;

}
