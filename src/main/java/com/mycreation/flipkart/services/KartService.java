package com.mycreation.flipkart.services;

import com.mycreation.flipkart.Repositories.KartRepo;
import com.mycreation.flipkart.Repositories.ProductRepo;
import com.mycreation.flipkart.Repositories.UserRepo;
import com.mycreation.flipkart.models.Kart;
import com.mycreation.flipkart.models.Product;
import com.mycreation.flipkart.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

@Service
public class KartService {

    @Autowired
    KartRepo kartRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    public ResponseEntity<Object> addItem(Long prodId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserEmail= authentication.getName();

        Optional<Product> product = productRepo.findById(prodId);
        User user= userRepo.findByEmail(curUserEmail);

        if (product.isPresent()){

            Optional<Kart> singleItem = kartRepo.findByUserAndProduct(user,product.get());
            if (singleItem.isPresent()){
                singleItem.get().setCount(singleItem.get().getCount()+1);
               return ResponseEntity.ok(kartRepo.save(singleItem.get()));
            }else {
                return ResponseEntity.ok(kartRepo.save(new Kart(product.get(),1,user)));
            }

        }
        else {
            return ResponseEntity.status(404).body("invalid product");
        }

    }

    public ResponseEntity<Object> removeItem(Long prodId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail = authentication.getName();

        Optional<Product> product = productRepo.findById(prodId);
        User curUser = userRepo.findByEmail(curUserMail);

        if (product.isPresent()){
            Optional<Kart> singleItem = kartRepo.findByUserAndProduct(curUser,product.get());
            if (singleItem.isPresent() && singleItem.get().getCount()>=2){

                singleItem.get().setCount(singleItem.get().getCount()-1);
              return ResponseEntity.ok(kartRepo.save(singleItem.get()));
            }
            else if(singleItem.get().getCount()==1) {
                kartRepo.delete(singleItem.get());
                return ResponseEntity.status(200).body(null);
            }
            else {
                return ResponseEntity.status(404).body("cart item does not exist");
            }
        }
        else {
          return ResponseEntity.status(404).body("invalid product");
        }

    }

    public ResponseEntity<Object> getKartItems_ofCurUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String curUserMail = authentication.getName();

        return ResponseEntity.ok(kartRepo.findByUser(userRepo.findByEmail(curUserMail)));
    }

}
