package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Assurance;
import tn.esprit.examnomprenom.entities.Contrat;
import tn.esprit.examnomprenom.entities.enums.TypeContrat;

import java.util.Set;

public interface AssuranceRepo extends JpaRepository<Assurance, Integer> {
    Assurance findFirstByBeneficiaire_idBenefOrderByContrat_dateEffetAsc(int idBenef);
    Set <Assurance> findAllByContrat_type(TypeContrat typeContrat);
    Set <Assurance> findAllByBeneficiaire_cin(int cin);
}
