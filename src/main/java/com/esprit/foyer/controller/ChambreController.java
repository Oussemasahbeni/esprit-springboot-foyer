package com.esprit.foyer.controller;

import com.esprit.foyer.entity.Chambre;
import com.esprit.foyer.service.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chambre")
public class ChambreController {

    private final IChambreService chambreService;
    
    @PostMapping()
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        return new ResponseEntity<>(chambreService.addChambre(chambre), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Chambre>> addBatchChambre(@RequestBody List<Chambre> chambres) {
        return new ResponseEntity<>(chambreService.addBatchChambre(chambres), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Chambre> updateChambre(@RequestBody Chambre chambre) {
        return new ResponseEntity<>(chambreService.updateChambre(chambre), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        return new ResponseEntity<>(chambreService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Chambre>> getAllChambre() {
        return new ResponseEntity<>(chambreService.findAll(), HttpStatus.OK);
    }

}
