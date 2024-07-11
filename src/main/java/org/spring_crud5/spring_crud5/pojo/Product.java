package org.spring_crud5.spring_crud5.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 64)
    private String name;
    
    @Column(nullable = false)
    private int price;
    
    @Column(nullable = false)
    private int vat;

    public Product() {}

    public Product(String name, int price, int vat) {
        this.name = name;
        this.price = price;
        this.vat = vat;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getVat() { return vat; }
    public void setVat(int vat) { this.vat = vat; }

    public int getFullPrice(boolean includeVat) {
        if (includeVat) {
            return price + (price * vat / 100);
        }
        return price;
    }
}
