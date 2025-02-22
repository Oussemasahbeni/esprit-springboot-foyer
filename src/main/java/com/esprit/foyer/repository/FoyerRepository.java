package com.esprit.foyer.repository;

import com.esprit.foyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
