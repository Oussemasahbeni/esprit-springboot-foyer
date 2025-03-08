package com.esprit.foyer.service;

import com.esprit.foyer.entity.Foyer;
import com.esprit.foyer.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return this.foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        Foyer existingFoyer = this.foyerRepository.findById(foyer.getId()).orElse(null);
        if (existingFoyer == null) {
            return null;
        }
        return this.foyerRepository.save(foyer);
    }

    @Override
    public void deleteById(Long id) {
        this.foyerRepository.deleteById(id);
    }

    @Override
    public Foyer findById(Long id) {
        return this.foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAll() {
        return this.foyerRepository.findAll();
    }

    @Override
    public List<Foyer> addBatchFoyer(List<Foyer> foyers) {
        return this.foyerRepository.saveAll(foyers);
    }
    

    private LocalDate getCurrentAcademicYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse("2023-09-01", formatter);
    }
}