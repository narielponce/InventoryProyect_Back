package com.skn.inventario.controller;

import com.skn.inventario.model.Brand;
import com.skn.inventario.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = {"http://localhost:3000"})
//@CrossOrigin(origins = {"*"})

@RestController
@RequestMapping("/api/v1")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getBrands(){
       return brandService.search();
    }

    @GetMapping("/brand/{id}")
    public Optional<Brand> getBrandById(@PathVariable Long id){
        return brandService.searchById(id);
    }
    @PostMapping("/brand")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand branch) {
        return brandService.save(branch);
    }
    @PutMapping("brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        return brandService.updateById(id, brand);
    }

    @DeleteMapping("brand/{id}")
    public ResponseEntity<Brand> deletedBrand(@PathVariable Long id) {
        return brandService.deleteById(id);
    }
}


