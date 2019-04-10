package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name= "utilisateur_topos")
@Getter
@Setter
public class TopoAPreter implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int utilisateur_topos_id;

    @Column (nullable = false)
    private boolean disponible;

    @Temporal(TemporalType.DATE)
    private Date date_retour;

    @ManyToOne
    @JoinColumn(name ="utilisateur_id")
    private Utilisateur utilisateurProprietaire;

    @ManyToOne
    @JoinColumn(name ="utilisateur_emprunteur_id")
    private Utilisateur utilisateurEmprunteur;

    @ManyToOne
    @JoinColumn(name ="topo_id")
    private Topo topoReference;

    public TopoAPreter(boolean disponible, Utilisateur utilisateurProprietaire, Topo topoReference) {
        this.disponible = disponible;
        this.utilisateurProprietaire = utilisateurProprietaire;
        this.topoReference = topoReference;
    }

    public TopoAPreter() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopoAPreter that = (TopoAPreter) o;
        return utilisateur_topos_id == that.utilisateur_topos_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur_topos_id);
    }
}
