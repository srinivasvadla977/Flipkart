package com.mycreation.flipkart.services;

import com.mycreation.flipkart.Repositories.ProductRepo;
import com.mycreation.flipkart.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    public ResponseEntity<Object> addProduct(Product product){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail = authentication.getName();

        try {
            Product p = new Product(product.getName(),product.getPrice(),curUserMail);
            return ResponseEntity.status(201).body(productRepo.save(p));
        }catch (Exception e){
            return ResponseEntity.status(400).body("invalid product");
        }
    }

    public ResponseEntity<Object> deleteProduct(Long productId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail= authentication.getName();

        if (productRepo.existsById(productId) && productRepo.findById(productId).get().getSellerEmail().equals(curUserMail)){

            productRepo.deleteById(productId);
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.status(403).body("either you are not the owner of this product or invalid product id");
    }

    public ResponseEntity<Object> updateProduct(Long productId, double price){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail= authentication.getName();

        if (productRepo.existsById(productId) && productRepo.findById(productId).get().getSellerEmail().equals(curUserMail)){

            Product p=productRepo.findById(productId).get();
            p.setPrice(price);
            productRepo.save(p);
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.status(403).body("you are not the owner of this product");
    }

    public ResponseEntity<Object> getAllProducts(){
        return ResponseEntity.ok(productRepo.findAll());
    }

    public ResponseEntity<Object> getAllProducts_ofSeller(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail= authentication.getName();

        return ResponseEntity.ok(productRepo.findBySellerEmail(curUserMail));
    }



}
