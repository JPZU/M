package com.macalz.macalz_backend.web.controller;

import com.macalz.macalz_backend.domain.dto.ClientDTO;
import com.macalz.macalz_backend.domain.dto.PaymentTypeDTO;
import com.macalz.macalz_backend.domain.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("payment-types")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<PaymentTypeDTO>> getAll() {
        return new ResponseEntity<>(paymentTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PaymentTypeDTO> getById(@PathVariable("id") int paymentTypeId) {
        return paymentTypeService.findById(paymentTypeId)
                .map(paymentType -> new ResponseEntity<>(paymentType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PaymentTypeDTO> save(@RequestBody PaymentTypeDTO paymentType) {
        return new ResponseEntity<>(paymentTypeService.save(paymentType), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaymentTypeById(@PathVariable("id") int paymentTypeId) {
        if (paymentTypeService.delete(paymentTypeId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
