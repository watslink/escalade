package com.sd.oc.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="voie")
public class Voie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int voie_id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable=false)
    private int secteur_id;

    @OneToMany(mappedBy ="voie", fetch = FetchType.EAGER)
    private List<Longueur> listLongueur;

    public Voie(String nom, int secteur_id) {
        this.nom = nom;
        this.secteur_id = secteur_id;
    }

    public Voie() {
    }

    public int getVoie_id() {
        return voie_id;
    }

    public void setVoie_id(int voie_id) {
        this.voie_id = voie_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(int secteur_id) {
        this.secteur_id = secteur_id;
    }

    public List<Longueur> getListLongueur() {
        return listLongueur;
    }

    public void setListLongueur(List<Longueur> listLongueur) {
        this.listLongueur = listLongueur;
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
