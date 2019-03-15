package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "utilisateur")
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int utilisateur_id;

    @Column(nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String mot_de_passe;

    @OneToMany(mappedBy ="utilisateur", fetch = FetchType.EAGER)
    private List<Commentaire> listCommentaire;



    public Utilisateur(String pseudo, String mail, String mot_de_passe) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.mot_de_passe = mot_de_passe;
    }

    public Utilisateur() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return utilisateur_id == that.utilisateur_id &&
                Objects.equals(pseudo, that.pseudo) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(mot_de_passe, that.mot_de_passe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur_id);
    }
}
