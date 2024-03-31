package com.skn.inventario.repository;

import com.skn.inventario.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categorie, Long> {
}
