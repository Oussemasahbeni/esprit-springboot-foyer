package com.esprit.foyer.service;

import com.esprit.foyer.entity.Chambre;
import com.esprit.foyer.entity.Foyer;

import java.util.List;

public interface IChambreService {

    Chambre addChambre(Chambre chambre);

    Chambre updateChambre(Chambre chambre);

    void deleteById(Long id);

    Chambre findById(Long id);

    List<Chambre> findAll();

    List<Chambre> addBatchChambre(List<Chambre> chambres);

    List<String> nomsSelonReservationsKeywords();

    List<String> nomsSelonReservations();

    Integer nombreChambresSelonReservationEtAnneeKeywords();

    Integer nombreChambresSelonReservationEtAnnee();

    Foyer getFoyerByNumeroChambreKeywords(List<Long> numeroChambres);

    Foyer getFoyerByNumeroChambre(List<Long> numeroChambres);
}
