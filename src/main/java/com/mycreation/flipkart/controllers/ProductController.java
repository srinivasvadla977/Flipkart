package com.mycreation.flipkart.controllers;

import com.mycreation.flipkart.models.Product;
import com.mycreation.flipkart.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @Operation(summary = "=> Enables Sellers to add a new product")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @PostMapping("/delete/{prodId}")
    @Operation(summary = "=> Enables Sellers to delete their own product")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long prodId){
        return productService.deleteProduct(prodId);
    }

    @PostMapping("update/{productId}/{price}")
    @Operation(summary = "=> Enables Sellers to update their own product")
    public ResponseEntity<Object> updateProdPrice(@PathVariable Long productId, @PathVariable double price){
        return productService.updateProduct(productId,price);
    }

    @GetMapping("/get")
    @Operation(summary = "=> Enables Users to view all existing products for sale")
    public ResponseEntity<Object> getAllProduct_forBuyer(){
        return  productService.getAllProducts();
    }

    @GetMapping("/get/mine")
    @Operation(summary = "=> Enables Sellers to view their own products all at a time")
    public ResponseEntity<Object> getAllProduct_forSeller(){
        return productService.getAllProducts_ofSeller();
    }


}
