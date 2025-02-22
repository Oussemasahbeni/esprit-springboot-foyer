package com.esprit.foyer.entity;

import com.esprit.foyer.entity.enums.TypeChambre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Chambre {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @ManyToOne
    private Bloc bloc;


    @OneToMany
    private Set<Reservation> reservations;
}
