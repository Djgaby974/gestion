package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue

    private Long id;
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "categorie_taches",
            joinColumns = @JoinColumn(name = "categorie_id"),
            inverseJoinColumns = @JoinColumn(name = "taches_id")
    )
    private List<TacheSimple> taches;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TacheSimple> getTaches() {
        return taches;
    }

    public void setTaches(List<TacheSimple> taches) {
        this.taches = taches;
    }


    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }
}
