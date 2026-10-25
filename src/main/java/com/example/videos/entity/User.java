package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = true, length = 64, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false, length = 48)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 48)
    private String lastName;

    @Column(name = "email", nullable = false, length = 128, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "birthdate", nullable = true)
    private LocalDate birthdate;

    @Column(name= "phone", nullable = false, length = 20)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    }

