package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.*;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue

    private Long id;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String contenu;

    @ManyToOne
    private Tache tache;

    public Commentaire(){

    }

    public Commentaire(String contenu){
        this.contenu = contenu;
    }
}
