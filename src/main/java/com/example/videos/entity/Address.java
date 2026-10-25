package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = true, length = 6)
    private String number;

    @Column(name = "street", nullable = false, length = 128)
    private String street;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "country", nullable = false, length = 64)
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;
}
