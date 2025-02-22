package com.esprit.foyer.service;

import com.esprit.foyer.entity.Chambre;
import com.esprit.foyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private final ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return this.chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        Chambre existingChambre = this.chambreRepository.findById(chambre.getId()).orElse(null);
        if (existingChambre == null) {
            return null;
        }
        return this.chambreRepository.save(chambre);
    }

    @Override
    public void deleteById(Long id) {
        this.chambreRepository.deleteById(id);
    }

    @Override
    public Chambre findById(Long id) {
        return this.chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> findAll() {
        return this.chambreRepository.findAll();
    }

    @Override
    public List<Chambre> addBatchChambre(List<Chambre> chambres) {
        return this.chambreRepository.saveAll(chambres);
    }
}
