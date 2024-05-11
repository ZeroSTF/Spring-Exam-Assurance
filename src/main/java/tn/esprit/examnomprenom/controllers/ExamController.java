package tn.esprit.examnomprenom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examnomprenom.entities.Assurance;
import tn.esprit.examnomprenom.entities.Beneficiaire;
import tn.esprit.examnomprenom.entities.Contrat;
import tn.esprit.examnomprenom.entities.enums.TypeContrat;
import tn.esprit.examnomprenom.services.IExamService;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class ExamController {
    private final IExamService examService;

    @PostMapping("/ajouterBeneficiaire")
    public Beneficiaire ajouterBeneficiaire(@RequestBody Beneficiaire bf) {
        return examService.ajouterBeneficiaire(bf);
    }

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat c) {
        return examService.ajouterContrat(c);
    }

    @PostMapping("/ajouterAssurance/{cinBf}/{matricule}")
    public Assurance ajouterAssurance(@RequestBody Assurance a, @PathVariable int cinBf, @PathVariable String matricule) {
        return examService.ajouterAssurance(a, cinBf, matricule);
    }

    @GetMapping("/getContratBf/{idBf}")
    public Contrat getContratBf(@PathVariable int idBf) {
        return examService.getContratBf(idBf);
    }

    @GetMapping("/getBeneficiairesByType/{typeContrat}")
    public Set<Beneficiaire> getBeneficiairesByType(@PathVariable TypeContrat typeContrat) {
        return examService.getBeneficiairesByType(typeContrat);
    }

    @GetMapping("/getMontantBf/{cinBf}")
    public float getMontantBf(@PathVariable int cinBf) {
        return examService.getMontantBf(cinBf);
    }

}
