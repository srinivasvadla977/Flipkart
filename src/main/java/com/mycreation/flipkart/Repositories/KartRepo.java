package com.mycreation.flipkart.Repositories;

import com.mycreation.flipkart.models.Kart;
import com.mycreation.flipkart.models.Product;
import com.mycreation.flipkart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KartRepo extends JpaRepository<Kart,Long> {

    List<Kart> findByUser(User byEmail);

    Optional<Kart> findByUserAndProduct(User user, Product product);
}
