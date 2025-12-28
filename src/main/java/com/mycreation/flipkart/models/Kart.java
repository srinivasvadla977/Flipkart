package com.mycreation.flipkart.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Kart_flipkart_wings")
public class Kart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Product product;

    private int count;

    @JoinColumn(referencedColumnName = "id",nullable = false)
    @ManyToOne
    private User user;

    public Kart() {
    }

    public Kart(Product product, int count, User user) {
        this.product = product;
        this.count = count;
        this.user = user;
    }

    public Kart(Long id, Product product, int count, User user) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
