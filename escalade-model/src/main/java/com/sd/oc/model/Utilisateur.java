package com.sd.oc.model;

import com.sd.oc.utils.BCryptManagerUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "utilisateur")
@Getter
@Setter
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int utilisateur_id;

    @Column(nullable = false)
    @NaturalId
    private String pseudo;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String mot_de_passe;

    @Column
    private boolean enabled;

    @Column
    private String role;

    @OneToMany(mappedBy ="utilisateur", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Commentaire> listCommentaire;

    @OneToMany(mappedBy ="utilisateurProprietaire", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<TopoAPreter> listTopoAPreter;

    @OneToMany(mappedBy ="utilisateurEmprunteur")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<TopoAPreter> listToposEmprunter;

    public Utilisateur(String pseudo, String mail, String mot_de_passe) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.mot_de_passe = BCryptManagerUtil.passwordencoder().encode(mot_de_passe);
        this.enabled=true;
        this.role="USER";
    }

    public Utilisateur() {
        this.enabled=true;
        this.role="USER";
    }


    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = BCryptManagerUtil.passwordencoder().encode(mot_de_passe);
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
