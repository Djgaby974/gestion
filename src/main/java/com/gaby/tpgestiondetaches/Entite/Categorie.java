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

    @OneToMany
    private List<Tache> taches;

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

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }


    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }
}
