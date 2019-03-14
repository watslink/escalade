package com.sd.oc.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "longueur")
public class Longueur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int longueur_id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String cotation;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int nombre_points;
    @Column(nullable = false)
    private int voie_id;

    public Longueur(String description, String cotation, int numero, int nombre_points, int voie_id) {
        super();
        this.description = description;
        this.cotation = cotation;
        this.numero = numero;
        this.nombre_points = nombre_points;
        this.voie_id=voie_id;
    }

    public Longueur(){
        super();
    }

    public int getLongueur_id() {
        return longueur_id;
    }

    public void setLongueur_id(int longueur_id) {
        this.longueur_id = longueur_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNombre_points() {
        return nombre_points;
    }

    public void setNombre_points(int nombre_points) {
        this.nombre_points = nombre_points;
    }

    public int getVoie_id() {
        return voie_id;
    }

    public void setVoie_id(int voie_id) {
        this.voie_id = voie_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Longueur longueur = (Longueur) o;
        return longueur_id == longueur.longueur_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longueur_id);
    }
}
