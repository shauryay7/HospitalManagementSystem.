package model;

import java.io.Serializable;

public class Drug implements Serializable {
    private String drugName;
    private int quantity;
    private double price;

    // Constructor
    public Drug(String drugName, int quantity, double price) {
        this.drugName = drugName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getDrugName() {
        return drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drug{Name='" + drugName + "', Quantity=" + quantity + ", Price=" + price + '}';
    }
}