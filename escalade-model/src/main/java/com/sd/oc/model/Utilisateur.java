package com.sd.oc.model;

import com.sd.oc.utils.BCryptManagerUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @Length(min=3, max=20, message ="Le pseudo doit contenir entre 3 et 20 caractères")
    private String pseudo;

    @Column(nullable = false)
    @Email(message="Format invalide")
    @NotBlank(message = "Veuillez entrer une adresse mail valide")
    private String mail;

    @Column(nullable = false)
    @Length(min=6, message = "Le mot de passe doit contenir  6 caractères minimum")
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
