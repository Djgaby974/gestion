package com.gaby.tpgestiondetaches.Controller;


import com.gaby.tpgestiondetaches.Entite.Commentaire;
import com.gaby.tpgestiondetaches.Entite.TacheSimple;
import com.gaby.tpgestiondetaches.Repository.CommentaireRepository;
import com.gaby.tpgestiondetaches.Repository.TacheSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/commentaires")

public class CommentaireController {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private TacheSimpleRepository tacheSimpleRepository;


    @GetMapping("/")
    public List<Commentaire> getAll(){
        return (List<Commentaire>) commentaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getById(@PathVariable Long id) {
        return commentaireRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Commentaire> create(@RequestBody Map<String, Object> data) {
        String contenu = (String) data.get("contenu");
        Long idTache = Long.valueOf(data.get("idTache").toString());

        Optional<TacheSimple> tache = tacheSimpleRepository.findById(idTache);
        if (tache.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(contenu);
        commentaire.setTache(tache.get());

        return ResponseEntity.ok(commentaireRepository.save(commentaire));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> update(@PathVariable Long id,
                                              @RequestBody Map<String, Object> data) {

        // 1. On récupère d'abord le commentaire existant
        return commentaireRepository.findById(id).map(commentaire -> {

            // 2. On met à jour le contenu s’il est présent
            if (data.containsKey("contenu")) {
                commentaire.setContenu(data.get("contenu").toString());
            }

            // 3. On met à jour la tâche si on reçoit un idTache
            if (data.containsKey("idTache")) {
                Long idTache = Long.valueOf(data.get("idTache").toString());
                tacheSimpleRepository.findById(idTache)
                        .ifPresent(commentaire::setTache);
            }

            // 4. On sauvegarde et on renvoie
            return ResponseEntity.ok(commentaireRepository.save(commentaire));

        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentaireRepository.deleteById(id);
    }


}
