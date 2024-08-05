package com.scm.scmproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder  //it requires  all argument annotation or constructor
public class Users
{



    @Id
    private String userId;
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;
    private String phoneNumber;

    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;


    @Enumerated(value = EnumType.STRING)
    private Provider provider=Provider.self;
    private String providerUserId;

       @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY ,orphanRemoval = true)
       private List<Contact> contacts=new ArrayList<>();



}
