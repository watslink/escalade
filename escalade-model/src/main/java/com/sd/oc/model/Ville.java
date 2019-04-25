package com.sd.oc.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ville")
@Getter
@Setter
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ville_id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "code_departement")
    private Departement departement;

    public Ville() {
    }

    public Ville(String nom, Departement departement) {
        this.nom = nom;
        this.departement = departement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return ville_id == ville.ville_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ville_id);
    }
}
