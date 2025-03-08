package com.esprit.foyer.service;

import com.esprit.foyer.entity.Chambre;
import com.esprit.foyer.entity.Foyer;
import com.esprit.foyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<String> nomsSelonReservationsKeywords() {
        LocalDate anneeUniversitaire = getCurrentAcademicYear();
        return chambreRepository.findDistinctByReservations_EstValdieTrueAndReservations_AnneUniversitaire(anneeUniversitaire);
    }

    @Override
    public List<String> nomsSelonReservations() {
        LocalDate anneeUniversitaire = getCurrentAcademicYear();
        return chambreRepository.nomsSelonReservations(anneeUniversitaire);
    }

    @Override
    public Integer nombreChambresSelonReservationEtAnneeKeywords() {
        LocalDate anneeUniversitaire = getCurrentAcademicYear();
        return chambreRepository.countByReservations_EstValdieFalseAndReservations_AnneUniversitaireLessThan(anneeUniversitaire);
    }

    @Override
    public Integer nombreChambresSelonReservationEtAnnee() {
        LocalDate anneeUniversitaire = getCurrentAcademicYear();
        return chambreRepository.nombreChambresSelonReservationEtAnnee(anneeUniversitaire);
    }

    @Override
    public Foyer getFoyerByNumeroChambreKeywords(List<Long> numeroChambres) {
        return chambreRepository.findDistinctByNumeroChambreIn(numeroChambres);
    }

    @Override
    public Foyer getFoyerByNumeroChambre(List<Long> numeroChambres) {
        return chambreRepository.getFoyerByNumeroChambre(numeroChambres);
    }

    private LocalDate getCurrentAcademicYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse("2023-09-01", formatter);
    }
}
