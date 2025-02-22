package com.esprit.foyer.repository;

import com.esprit.foyer.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
}
