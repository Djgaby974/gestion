package com.gaby.tpgestiondetaches.Controller;


import com.gaby.tpgestiondetaches.Entite.Utilisateur;
import com.gaby.tpgestiondetaches.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/")
    public List<Utilisateur> getAll(){
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable Long id){
        return utilisateurRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        if (!utilisateurRepository.existsById(id)) return ResponseEntity.notFound().build();
        utilisateur.setId(id);
        return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }




}
