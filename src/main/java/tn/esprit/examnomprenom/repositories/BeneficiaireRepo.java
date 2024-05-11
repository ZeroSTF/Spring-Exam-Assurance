package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Beneficiaire;
import tn.esprit.examnomprenom.entities.Contrat;

public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Integer>{
    Beneficiaire findByCin(int cin);

}
