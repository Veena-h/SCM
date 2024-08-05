package com.scm.scmproject.forms;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Userform
{
    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;



}
