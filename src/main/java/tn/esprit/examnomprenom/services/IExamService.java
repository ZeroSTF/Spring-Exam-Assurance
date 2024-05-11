package tn.esprit.examnomprenom.services;

import tn.esprit.examnomprenom.entities.Assurance;
import tn.esprit.examnomprenom.entities.Beneficiaire;
import tn.esprit.examnomprenom.entities.Contrat;
import tn.esprit.examnomprenom.entities.enums.TypeContrat;

import java.util.List;
import java.util.Set;

public interface IExamService {
    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);
    Contrat ajouterContrat(Contrat c);
    Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);
    Contrat getContratBf(int idBf);
    Set<Beneficiaire> getBeneficiairesByType(TypeContrat typeContrat);
    float getMontantBf(int cinBf);
    void statistiques();
}
