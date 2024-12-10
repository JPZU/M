package com.macalz.macalz_backend.web.controller;


import com.macalz.macalz_backend.domain.dto.UserTypeDTO;
import com.macalz.macalz_backend.domain.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-types")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<UserTypeDTO>> getAll() {
        return new ResponseEntity<>(userTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserTypeDTO> getById(@PathVariable("id") int userTypeId) {
        return userTypeService.findUserTypeById(userTypeId)
                .map(userType -> new ResponseEntity<>(userType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserTypeDTO> save(@RequestBody UserTypeDTO userTypeDTO) {
        return new ResponseEntity<>(userTypeService.save(userTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int userTypeId) {
        if(userTypeService.deleteUserTypeById(userTypeId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
