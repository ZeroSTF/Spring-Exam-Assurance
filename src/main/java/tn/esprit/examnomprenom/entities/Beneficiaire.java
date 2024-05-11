package tn.esprit.examnomprenom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBenef;
    int cin;
    String nom;
    String prenom;
    String profession;
    float salaire;

    @JsonIgnore
    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Assurance> assurances = new LinkedHashSet<>();

}
