package com.sd.oc.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int site_id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "code_departement")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Secteur> listSecteur;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "topo_sites",
            joinColumns = {@JoinColumn(name = "site_id")},
            inverseJoinColumns = {@JoinColumn(name = "topo_id")})
    private Set<Topo> listTopo;

    public Site(String nom, Departement departement, Ville ville) {
        this.nom = nom;
        this.departement = departement;
        this.ville = ville;
    }

    public Site() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return site_id == site.site_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(site_id);
    }
}
