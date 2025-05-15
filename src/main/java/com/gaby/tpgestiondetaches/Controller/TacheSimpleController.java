package com.gaby.tpgestiondetaches.Controller;


import com.gaby.tpgestiondetaches.Entite.TacheSimple;
import com.gaby.tpgestiondetaches.Repository.TacheSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches-simples")
public class TacheSimpleController {

    @Autowired
    private TacheSimpleRepository tacheSimpleRepository;

    @GetMapping("/")
    public List<TacheSimple> getAll() {
        return (List<TacheSimple>) tacheSimpleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacheSimple> getById(@PathVariable Long id) {
        return tacheSimpleRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public TacheSimple create(@RequestBody TacheSimple tache) {
        return tacheSimpleRepository.save(tache);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacheSimple> update(@PathVariable Long id, @RequestBody TacheSimple tache) {
        if (!tacheSimpleRepository.existsById(id)) return ResponseEntity.notFound().build();
        tache.setId(id);
        return ResponseEntity.ok(tacheSimpleRepository.save(tache));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tacheSimpleRepository.deleteById(id);
    }

    @GetMapping("/terminees")
    public List<TacheSimple> getTachesTerminees() {
        return tacheSimpleRepository.findByTermineeTrue();
    }

    @GetMapping("/en-cours")
    public List<TacheSimple> getTachesEnCours() {
        return tacheSimpleRepository.findByTermineeFalse();
    }


}
