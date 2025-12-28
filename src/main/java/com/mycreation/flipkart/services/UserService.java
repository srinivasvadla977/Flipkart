package com.mycreation.flipkart.services;

import com.mycreation.flipkart.Repositories.UserRepo;
import com.mycreation.flipkart.models.User;
import com.mycreation.flipkart.models.UserAuthReq;
import com.mycreation.flipkart.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<Object> registerUser(User user){

        try{
            User u = new User(user.getName(), user.getEmail(), user.getRole(), passwordEncoder.encode(user.getPassword()));
           return ResponseEntity.ok(userRepo.save(u));
        }catch (Exception e){
            return ResponseEntity.status(400).body("Invalid input");
        }
    }

    public ResponseEntity<Object> loginUser(UserAuthReq authReq){

            if (userRepo.existsByEmail(authReq.getEmail()) && passwordEncoder.matches(authReq.getPassword(), userRepo.findByEmail(authReq.getEmail()).getPassword()) ){
                return ResponseEntity.ok(jwtUtil.generateToken(authReq.getEmail(), Arrays.asList(userRepo.findByEmail(authReq.getEmail()).getRole().toString())));
            }
            return ResponseEntity.status(404).body("invalid credentials");
    }


}
