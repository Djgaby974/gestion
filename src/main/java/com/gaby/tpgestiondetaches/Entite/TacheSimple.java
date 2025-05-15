package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tachesimple")
public class TacheSimple extends Tache {

    @ManyToMany(mappedBy = "taches")
    private List<Categorie> categories;


    private LocalDate dateEcheance;


    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public TacheSimple(){

    }
    public TacheSimple(String titre){
        super(titre);
    }




}
