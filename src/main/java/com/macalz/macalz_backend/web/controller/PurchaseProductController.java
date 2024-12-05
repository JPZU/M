package com.macalz.macalz_backend.web.controller;

import com.macalz.macalz_backend.domain.dto.ProductDTO;
import com.macalz.macalz_backend.domain.dto.PurchaseProductDTO;
import com.macalz.macalz_backend.domain.service.PurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase-products")
public class PurchaseProductController {
    @Autowired
    private PurchaseProductService purchaseProductService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseProductDTO>> getAll() {
        return new ResponseEntity<>(purchaseProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PurchaseProductDTO> getById(@PathVariable("id") long purchaseProductId) {
        return purchaseProductService.findById(purchaseProductId)
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseProductDTO> save(@RequestBody PurchaseProductDTO purchaseProduct) {
        return new ResponseEntity<>(purchaseProductService.save(purchaseProduct), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePurchaseProductById(@PathVariable("id") long purchaseProductId) {
        if (purchaseProductService.deleteById(purchaseProductId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
