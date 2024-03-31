package com.skn.inventario.service;

import com.skn.inventario.model.Branch;
import com.skn.inventario.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public ResponseEntity<List<Branch>> search(){
        try{
            List<Branch> branchList = (List<Branch>) branchRepository.findAll();
            return new ResponseEntity<>(branchList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Optional<Branch> searchById(@PathVariable Long id){
        return branchRepository.findById(id);
    }

    public ResponseEntity<Branch> save(Branch branch) {
        try {
            Branch branchSaved = branchRepository.save(branch);
            return new ResponseEntity<Branch>(branchSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Branch> updateById(Long id, Branch branch){
        Optional<Branch> branchSearch = branchRepository.findById(id);
        if (branchSearch.isPresent()) {
            branchSearch.get().setName(branch.getName());
            branchSearch.get().setDescription(branch.getDescription());

            Branch branchToUpdate = branchRepository.save(branchSearch.get());
            return new ResponseEntity<>(branchToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Branch> deleteById(Long id) {
        branchRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
