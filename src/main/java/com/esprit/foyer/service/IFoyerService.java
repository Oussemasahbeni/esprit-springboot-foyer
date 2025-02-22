package com.esprit.foyer.service;

import com.esprit.foyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer addFoyer(Foyer chambre);

    Foyer updateFoyer(Foyer chambre);

    void deleteById(Long id);

    Foyer findById(Long id);

    List<Foyer> findAll();

    List<Foyer> addBatchFoyer(List<Foyer> chambres);
}
