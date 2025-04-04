package com.rest.banking.controller;

import com.rest.banking.dto.DebitCardDTO;
import com.rest.banking.model.DebitCard;
import com.rest.banking.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debit")
public class DebitCardController {

    @Autowired
    DebitCardService debitCardService;

    @PostMapping("/applyDebitCard/{acc_id}")
    public ResponseEntity<DebitCard> applyDebitCard(@PathVariable Long acc_id, @RequestBody DebitCardDTO debitCardDTO){
        DebitCard debitCard = debitCardService.applyDebitCard(acc_id, debitCardDTO);
        return ResponseEntity.ok(debitCard);
    }

}
