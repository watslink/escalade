package com.sd.oc.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="voie")
@Getter
@Setter
public class Voie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voie_id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name="secteur_id")
    private Secteur secteur;

    @OneToMany(mappedBy ="voie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Longueur> listLongueur;

    public Voie(String nom, Secteur secteur) {
        this.nom = nom;
        this.secteur = secteur;
    }

    public Voie() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voie voie = (Voie) o;
        return voie_id == voie.voie_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voie_id);
    }
}
