package com.esprit.foyer.repository;

import com.esprit.foyer.entity.Chambre;
import com.esprit.foyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<String> findDistinctByReservations_EstValdieTrueAndReservations_AnneUniversitaire(LocalDate anneeUniversitaire);

    Integer countByReservations_EstValdieFalseAndReservations_AnneUniversitaireLessThan(LocalDate anneeUniversitaire);

    Foyer findDistinctByNumeroChambreIn(List<Long> numeroChambres);

    // Liste des noms des étudiants ayant effectué une réservation valide pour l'année universitaire courante
    @Query("SELECT DISTINCT e.nomEt FROM Reservation r JOIN r.etudiants e WHERE r.estValdie = true AND r.anneUniversitaire = :anneeUniversitaire")
    List<String> nomsSelonReservations(@Param("anneeUniversitaire") LocalDate anneeUniversitaire);

    // Nombre de chambres ayant une réservation non valide et dont l'année universitaire est inférieure à l'année universitaire courante
    @Query("SELECT COUNT(c) FROM Chambre c JOIN c.reservations r WHERE r.estValdie = false AND r.anneUniversitaire < :anneeUniversitaire")
    Integer nombreChambresSelonReservationEtAnnee(@Param("anneeUniversitaire") LocalDate anneeUniversitaire);

    // Foyer associé aux chambres dont les numéros figurent dans une liste donnée
    @Query("SELECT DISTINCT c.bloc.foyer FROM Chambre c WHERE c.numeroChambre IN :numeroChambres")
    Foyer getFoyerByNumeroChambre(@Param("numeroChambres") List<Long> numeroChambres);
}
