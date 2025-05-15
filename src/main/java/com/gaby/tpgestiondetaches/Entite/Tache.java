package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.*;

@Entity
@Table(name = "tache")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tache {
    @Id
    @GeneratedValue

    private Long id;
    private String titre;

    public boolean isTerminee() {
        return terminee;
    }

    public void setTerminee(boolean terminee) {
        this.terminee = terminee;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private boolean terminee;


    @ManyToOne
    private Utilisateur utilisateur;

    public Tache(){

    }

    public Tache(String titre){
        this.titre = titre;
    }


}
