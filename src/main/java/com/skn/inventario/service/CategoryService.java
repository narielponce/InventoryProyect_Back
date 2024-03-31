package com.skn.inventario.service;

import com.skn.inventario.model.Categorie;
import com.skn.inventario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<Categorie>> search(){
        try{
            List<Categorie> categorieList = (List<Categorie>) categoryRepository.findAll();
            return new ResponseEntity<>(categorieList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
