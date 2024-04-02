package com.skn.inventario.service;

import com.skn.inventario.model.Brand;
import com.skn.inventario.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public ResponseEntity<List<Brand>> search(){
        try{
            List<Brand> branchList = (List<Brand>) brandRepository.findAll();
            return new ResponseEntity<>(branchList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Optional<Brand> searchById(@PathVariable Long id){
        return brandRepository.findById(id);
    }

    public ResponseEntity<Brand> save(Brand brand) {
        try {
            Brand branchSaved = brandRepository.save(brand);
            return new ResponseEntity<Brand>(branchSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Brand> updateById(Long id, Brand brand){
        Optional<Brand> brandSearch = brandRepository.findById(id);
        if (brandSearch.isPresent()) {
            brandSearch.get().setName(brand.getName());
            brandSearch.get().setDescription(brand.getDescription());

            Brand branchToUpdate = brandRepository.save(brandSearch.get());
            return new ResponseEntity<>(branchToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Brand> deleteById(Long id) {
        brandRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
