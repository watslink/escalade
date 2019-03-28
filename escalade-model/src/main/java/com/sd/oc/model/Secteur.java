package com.sd.oc.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="secteur")
@Getter
@Setter
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int secteur_id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name="site_id")
    private Site site;

    @OneToMany(mappedBy ="secteur", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Voie> listVoie;

    public Secteur(String nom, Site site, Set<Voie> listVoie) {
        this.nom = nom;
        this.site = site;
        this.listVoie=listVoie;
    }

    public Secteur() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secteur secteur = (Secteur) o;
        return secteur_id == secteur.secteur_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secteur_id);
    }
}
