package org.spring_crud5.spring_crud5.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "ordine_product",
        joinColumns = @JoinColumn(name = "ordine_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Ordine() {}

    public Ordine(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public int getFullPrice(boolean includeVat) {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getFullPrice(includeVat);
        }
        return totalPrice;
    }
}