package com.skn.inventario.service;

import com.skn.inventario.model.Branch;
import com.skn.inventario.model.Product;
import com.skn.inventario.repository.BranchRepository;
import com.skn.inventario.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> search(){
        try{
            List<Product> productList = (List<Product>) productRepository.findAll();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
