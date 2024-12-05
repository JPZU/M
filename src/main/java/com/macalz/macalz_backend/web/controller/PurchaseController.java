package com.macalz.macalz_backend.web.controller;



import com.macalz.macalz_backend.domain.dto.PurchaseDTO;
import com.macalz.macalz_backend.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<PurchaseDTO> getById(@PathVariable("id") long purchaseId) {
        return purchaseService.findPurchaseById(purchaseId)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePurchaseById(@PathVariable("id") long purchaseId) {
        if (purchaseService.delete(purchaseId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
