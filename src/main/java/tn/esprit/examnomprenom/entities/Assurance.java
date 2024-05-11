package tn.esprit.examnomprenom.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAssurance;
    String designation;
    float montant;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contrat_id_contrat")
    private Contrat contrat;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiaire_id_benef")
    private Beneficiaire beneficiaire;

}
