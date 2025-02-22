package com.esprit.foyer.controller;

import com.esprit.foyer.entity.Foyer;
import com.esprit.foyer.service.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
@AllArgsConstructor
public class FoyerController {

    private final IFoyerService foyerService;

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        Foyer createdFoyer = foyerService.addFoyer(foyer);
        return ResponseEntity.ok(createdFoyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        foyer.setId(id);
        Foyer updatedFoyer = foyerService.updateFoyer(foyer);
        if (updatedFoyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFoyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable Long id) {
        foyerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable Long id) {
        Foyer foyer = foyerService.findById(id);
        if (foyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foyer);
    }

    @GetMapping
    public ResponseEntity<List<Foyer>> getAllFoyers() {
        List<Foyer> foyers = foyerService.findAll();
        return ResponseEntity.ok(foyers);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Foyer>> addBatchFoyer(@RequestBody List<Foyer> foyers) {
        List<Foyer> createdFoyers = foyerService.addBatchFoyer(foyers);
        return ResponseEntity.ok(createdFoyers);
    }
}