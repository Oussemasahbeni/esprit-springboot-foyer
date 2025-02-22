package com.esprit.foyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private String nomUniversite;

    @OneToOne
    private Foyer foyer;
}