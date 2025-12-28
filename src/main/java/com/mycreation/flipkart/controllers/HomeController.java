package com.mycreation.flipkart.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


    @GetMapping("")
    @Operation(summary = "=> Greetings Page")
    public ResponseEntity<Object> greetings(){
        return ResponseEntity.ok("welcome back..!");
    }

    @GetMapping("/{name}")
    @Operation(summary = "=> Greetings Page with user name")
    public ResponseEntity<Object> greetingsUser(@PathVariable String name){
        return ResponseEntity.ok("welcome back.."+name+" !");
    }

}
