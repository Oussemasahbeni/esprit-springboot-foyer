package com.esprit.foyer.service;

import com.esprit.foyer.entity.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc addBloc(Bloc chambre);

    Bloc updateBloc(Bloc chambre);

    void deleteById(Long id);

    Bloc findById(Long id);

    List<Bloc> findAll();

    List<Bloc> addBatchBloc(List<Bloc> chambres);
}
