package com.app.devgpt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private String projectImage;
    private String projectUrl;
    private String projectType;
    private String projectLanguage;
    private String projectStatus;
    private String projectOwner;
    private String projectOwnerEmail;
    private String projectOwnerPhone;
    private String projectOwnerAddress;
    private String projectOwnerCity;
    private String projectOwnerState;
    private String projectOwnerZip;
    private String projectOwnerCountry;
    private String projectOwnerWebsite;
    private String projectOwnerTwitter;
    private String projectOwnerFacebook;
    private String projectOwnerLinkedin;
    private String projectOwnerInstagram;
    private String projectOwnerYoutube;
    private String projectOwnerGithub;
    private String projectOwnerBitbucket;
    private String projectOwnerTrello;
    private String projectOwnerTumblr;
    private String projectOwnerDiscord;
    private String projectOwnerReddit;
    private String projectOwnerTwitch;
    private String projectOwnerSpotify;
    private String projectOwnerSoundcloud;
    private String projectOwnerBehance;


    public void setUser(UserDetails savedUser) {
    }
}
