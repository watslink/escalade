package com.sd.oc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="site")
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

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="topo_sites",
            joinColumns={@JoinColumn(name="topo_id")},
            inverseJoinColumns={@JoinColumn(name="site_id")})
    private List<Site> listSite;

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
