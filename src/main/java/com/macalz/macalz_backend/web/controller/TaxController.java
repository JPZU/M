package com.macalz.macalz_backend.web.controller;

import com.macalz.macalz_backend.domain.dto.TaxDTO;
import com.macalz.macalz_backend.domain.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taxes")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping("/all")
    public ResponseEntity<List<TaxDTO>> getAll() {
        return new ResponseEntity<>(taxService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TaxDTO> getById(@PathVariable("id") int taxId) {
        return taxService.findTaxById(taxId)
                .map(tax -> new ResponseEntity<>(tax, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<TaxDTO> save(@RequestBody TaxDTO taxDTO) {
        return new ResponseEntity<>(taxService.save(taxDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaxDTO> deleteTaxById(@PathVariable("id") int taxId) {
        if(taxService.deleteTaxById(taxId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
