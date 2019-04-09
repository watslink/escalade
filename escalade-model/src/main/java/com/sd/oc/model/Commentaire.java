package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "commentaire")
@Getter
@Setter
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentaire_id;

    @Column(nullable = false)
    private String texte;

    @ManyToOne
    @JoinColumn(name ="voie_id")
    private Voie voie;

    @ManyToOne
    @JoinColumn(name ="utilisateur_id")
    private Utilisateur utilisateur;

    public Commentaire(String texte) {
        this.texte = texte;
    }

    public Commentaire() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentaire that = (Commentaire) o;
        return commentaire_id == that.commentaire_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentaire_id);
    }
}
