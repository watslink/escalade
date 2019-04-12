package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="departement")
@Getter
@Setter
public class Departement {

    @Id
    private String code;

    @Column
    private String nom;

    @OneToMany(mappedBy ="departement", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Site> listSite;

    public Departement() {
    }

    public Departement(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departement that = (Departement) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
