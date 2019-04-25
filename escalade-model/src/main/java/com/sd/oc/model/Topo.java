package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "topo")
@Getter
@Setter
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topo_id;

    @Column
    private String nom;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "topo_sites",
            joinColumns = {@JoinColumn(name = "topo_id")},
            inverseJoinColumns = {@JoinColumn(name = "site_id")})
    private Set<Site> listSite;

    @OneToMany(mappedBy = "topoReference", orphanRemoval = true)
    private Set<TopoAPreter> listTopoAPreter;

    public Topo(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Topo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topo topo = (Topo) o;
        return topo_id == topo.topo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topo_id);
    }
}
