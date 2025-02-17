package com.banquito.cbs.comisiones.repositorio;

import com.banquito.cbs.comisiones.modelo.Comision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComisionRepository extends MongoRepository<Comision, Integer> {
}
