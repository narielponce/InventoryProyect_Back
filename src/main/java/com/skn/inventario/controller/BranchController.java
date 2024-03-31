package com.skn.inventario.controller;

import com.skn.inventario.model.Branch;
import com.skn.inventario.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = {"http://localhost:3000"})
//@CrossOrigin(origins = {"*"})

@RestController
@RequestMapping("/api/v1")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/branchs")
    public ResponseEntity<List<Branch>> getBranchs(){
       return branchService.search();
    }

    @GetMapping("/branch/{id}")
    public Optional<Branch> getBranchById(@PathVariable Long id){
        return branchService.searchById(id);
    }
    @PostMapping("/branch")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        return branchService.save(branch);
    }
    @PutMapping("branch/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        return branchService.updateById(id, branch);
    }

    @DeleteMapping("branch/{id}")
    public ResponseEntity<Branch> deletedBranch(@PathVariable Long id) {
        return branchService.deleteById(id);
    }
}


