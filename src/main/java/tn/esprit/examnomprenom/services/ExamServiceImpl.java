package tn.esprit.examnomprenom.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examnomprenom.entities.Assurance;
import tn.esprit.examnomprenom.entities.Beneficiaire;
import tn.esprit.examnomprenom.entities.Contrat;
import tn.esprit.examnomprenom.entities.enums.TypeContrat;
import tn.esprit.examnomprenom.repositories.AssuranceRepo;
import tn.esprit.examnomprenom.repositories.BeneficiaireRepo;
import tn.esprit.examnomprenom.repositories.ContratRepo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamServiceImpl implements IExamService {
    private final BeneficiaireRepo beneficiaireRepo;
    private final ContratRepo contratRepo;
    private final AssuranceRepo assuranceRepo;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireRepo.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepo.save(c);
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Beneficiaire bf = beneficiaireRepo.findByCin(cinBf);
        Contrat c = contratRepo.findByMatricule(matricule);
        a.setBeneficiaire(bf);
        a.setContrat(c);
        return assuranceRepo.save(a);
    }

    @Override
    public Contrat getContratBf(int idBf) {
        return assuranceRepo.findFirstByBeneficiaire_idBenefOrderByContrat_dateEffetAsc(idBf).getContrat();
    }

    @Override
    public Set<Beneficiaire> getBeneficiairesByType(TypeContrat typeContrat) {
        return assuranceRepo.findAllByContrat_type(typeContrat).stream().map(Assurance::getBeneficiaire).collect(Collectors.toSet());
    }

    //afficher le montant annuel des assurances par beneficiaire (vous devez faire le calcul necessaire pour les types de contrat semestriel et mensuel)

    @Override
    public float getMontantBf(int cinBf) {
        Set<Assurance> assurances = assuranceRepo.findAllByBeneficiaire_cin(cinBf);
        float montant = 0;
        for (Assurance a : assurances) {
            if (a.getContrat().getType() == TypeContrat.Annuel) {
                montant += a.getMontant();
            } else if (a.getContrat().getType() == TypeContrat.Semestriel) {
                montant += a.getMontant() * 2;
            } else if (a.getContrat().getType() == TypeContrat.Mensuel) {
                montant += a.getMontant() * 12;
            }
        }
        return montant;
    }

    @Scheduled(fixedRate = 60000)
    public void statistiques() {
        List<Assurance> assurances = assuranceRepo.findAll();
        assurances.stream().collect(Collectors.groupingBy(Assurance::getBeneficiaire, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> log.info("Cin: " + e.getKey().getCin() + " Nombre d'assurances: " + e.getValue()));
    }
}
