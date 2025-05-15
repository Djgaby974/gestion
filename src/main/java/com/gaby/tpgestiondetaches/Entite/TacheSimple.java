package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tachesimple")
public class TacheSimple extends Tache {

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
