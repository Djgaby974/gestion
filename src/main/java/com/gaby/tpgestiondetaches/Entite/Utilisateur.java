package com.gaby.tpgestiondetaches.Entite;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue

    private Long id;
    private String nom;
    private String email;
    private String password;

}
