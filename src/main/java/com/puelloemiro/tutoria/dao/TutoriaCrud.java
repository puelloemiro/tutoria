package com.puelloemiro.tutoria.dao;

import com.puelloemiro.tutoria.modelo.Tutoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoriaCrud extends CrudRepository<Tutoria, Long> {

}
