package com.esprit.foyer.controller;

import com.esprit.foyer.entity.Bloc;
import com.esprit.foyer.service.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
@AllArgsConstructor
public class BlocController {

    private final IBlocService blocService;

    @PostMapping
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        Bloc createdBloc = blocService.addBloc(bloc);
        return ResponseEntity.ok(createdBloc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        bloc.setId(id);
        Bloc updatedBloc = blocService.updateBloc(bloc);
        if (updatedBloc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBloc);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        blocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.findById(id);
        if (bloc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bloc);
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.findAll();
        return ResponseEntity.ok(blocs);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Bloc>> addBatchBloc(@RequestBody List<Bloc> blocs) {
        List<Bloc> createdBlocs = blocService.addBatchBloc(blocs);
        return ResponseEntity.ok(createdBlocs);
    }
}