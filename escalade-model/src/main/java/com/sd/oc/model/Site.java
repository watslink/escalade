package com.sd.oc.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="site")
@Getter
@Setter
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int site_id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name="ville_id")
    private Ville ville;

    @OneToMany(mappedBy ="site", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Secteur> listSecteur;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="topo_sites",
            joinColumns={@JoinColumn(name="site_id")},
            inverseJoinColumns={@JoinColumn(name="topo_id")})
    private Set<Topo> listTopo;

    public Site(String nom, Ville ville) {
        this.nom = nom;
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
