package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Contrat;

public interface ContratRepo extends JpaRepository<Contrat, Integer> {
    Contrat findByMatricule(String matricule);
}
