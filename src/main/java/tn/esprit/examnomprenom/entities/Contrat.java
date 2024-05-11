package tn.esprit.examnomprenom.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.examnomprenom.entities.enums.TypeContrat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idContrat;
    String matricule;
    @Temporal(TemporalType.DATE)
    Date dateEffet;
    @Enumerated(EnumType.STRING)
    TypeContrat type;
}
