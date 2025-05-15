package com.gaby.tpgestiondetaches.Repository;

import com.gaby.tpgestiondetaches.Entite.TacheSimple;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacheSimpleRepository extends CrudRepository<TacheSimple, Long> {
    List<TacheSimple> findByTermineeTrue();   // tâches terminées
    List<TacheSimple> findByTermineeFalse();  // tâches en cours
}