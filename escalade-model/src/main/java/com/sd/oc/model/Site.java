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
    @JoinColumn(name="code_departement")
    private Departement departement;

    @Column(nullable = false)
    private String ville;

    @OneToMany(mappedBy ="site", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Secteur> listSecteur;

    public Site(String nom, Departement departement, String ville) {
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
