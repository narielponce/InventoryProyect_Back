package com.skn.inventario.repository;

import com.skn.inventario.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
}
