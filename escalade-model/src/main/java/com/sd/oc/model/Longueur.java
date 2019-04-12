package com.sd.oc.model;



import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "longueur")
@Getter
@Setter
public class Longueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int longueur_id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String cotation;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int hauteur;
    @Column(nullable = false)
    private int nombre_points;
    @ManyToOne
    @JoinColumn(name="voie_id")
    private Voie voie;


    public Longueur(String description, String cotation, int numero, int hauteur, int nombre_points, Voie voie) {
        this.description = description;
        this.cotation = cotation;
        this.numero = numero;
        this.hauteur=hauteur;
        this.nombre_points = nombre_points;
        this.voie=voie;
    }

    public Longueur(){
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
