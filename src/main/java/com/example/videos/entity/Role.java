package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import com.example.videos.enums.RoleEnum;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, unique = true, length = 32)
    private  RoleEnum role;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
