package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String address;
    private double price;
    private double size;
    private String description;

    protected Property() {}

    public Property(String address, double price, double size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Property[id=%d, address='%s', price=%.2f, size=%.2f, description='%s']",
                id, address, price, size, description);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }
}
