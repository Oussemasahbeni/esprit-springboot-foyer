package com.esprit.foyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cin;
    private LocalDate dateNaissance;
    private String ecole;
    private String nomEt;
    private String prenomEt;

    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}