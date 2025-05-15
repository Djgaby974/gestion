package com.gaby.tpgestiondetaches.Controller;


import com.gaby.tpgestiondetaches.Entite.Categorie;
import com.gaby.tpgestiondetaches.Entite.TacheSimple;
import com.gaby.tpgestiondetaches.Repository.CategorieRepository;
import com.gaby.tpgestiondetaches.Repository.TacheSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private TacheSimpleRepository tacheSimpleRepository;


    @GetMapping("/")
    public List<Categorie> getAll(){
    return (List<Categorie>) categorieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return categorieRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Categorie create(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie categorie) {
        if (!categorieRepository.existsById(id)) return ResponseEntity.notFound().build();
        categorie.setId(id);
        return ResponseEntity.ok(categorieRepository.save(categorie));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }

    @PutMapping("/{id}/ajouter-taches")
    public ResponseEntity<Categorie> ajouterTachesDansCategorie(
            @PathVariable Long id,
            @RequestBody List<Long> idsTaches) {

        return categorieRepository.findById(id).map(categorie -> {
            List<TacheSimple> nouvellesTaches = new ArrayList<>();
            tacheSimpleRepository.findAllById(idsTaches).forEach(nouvellesTaches::add);

            // Initialise si null
            if (categorie.getTaches() == null) {
                categorie.setTaches(new ArrayList<>());
            }

            // Ajoute sans écraser
            categorie.getTaches().addAll(nouvellesTaches);

            return ResponseEntity.ok(categorieRepository.save(categorie));
        }).orElse(ResponseEntity.notFound().build());
    }



}
