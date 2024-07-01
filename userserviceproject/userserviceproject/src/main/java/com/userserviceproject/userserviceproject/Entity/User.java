package com.userserviceproject.userserviceproject.Entity;






import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users1")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
