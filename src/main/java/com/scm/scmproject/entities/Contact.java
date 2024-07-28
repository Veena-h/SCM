package com.scm.scmproject.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact
{
    @Id
    private String id;
    private  String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private boolean favorites=false;


    private String instagramLink;
    private String facebookLink;

    //private List<String> socialLinks=new ArrayList<>()

    @ManyToOne
    private  Users user;

    @OneToMany(mappedBy = "contact" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER ,orphanRemoval = true)
    private List<SocialLinks> links=new ArrayList<>();

}
