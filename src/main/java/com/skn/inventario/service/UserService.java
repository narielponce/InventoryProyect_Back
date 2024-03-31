package com.skn.inventario.service;

import com.skn.inventario.model.User;
import com.skn.inventario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> search(){
        try{
            List<User> userList = (List<User>) userRepository.findAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
