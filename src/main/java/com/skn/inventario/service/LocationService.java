package com.skn.inventario.service;

import com.skn.inventario.model.Location;
import com.skn.inventario.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public ResponseEntity<List<Location>> search(){
        try{
            List<Location> locationList = (List<Location>) locationRepository.findAll();
            return new ResponseEntity<>(locationList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
