package com.mycreation.flipkart.controllers;

import com.mycreation.flipkart.services.KartService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class KartController {

    @Autowired
    KartService kartService;

    @PostMapping("/add/{prodId}")
    @Operation(summary = "=> To add an item to user's cart")
    public ResponseEntity<Object> addItem_toCart(@PathVariable Long prodId){
        return kartService.addItem(prodId);
    }

    @PostMapping("/remove/{prodId}")
    @Operation(summary = "=> To remove an item from user's cart")
    public ResponseEntity<Object> removeItem_fromCart(@PathVariable Long prodId){
        return kartService.removeItem(prodId);
    }

    @GetMapping("/get")
    @Operation(summary = "=> To get all items from user's cart")
    public ResponseEntity<Object> getUserCart(){
        return kartService.getKartItems_ofCurUser();
    }

}
