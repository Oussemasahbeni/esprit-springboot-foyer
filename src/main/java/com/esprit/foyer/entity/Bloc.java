package com.esprit.foyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long capaciteBloc;
    private String nomBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;
}