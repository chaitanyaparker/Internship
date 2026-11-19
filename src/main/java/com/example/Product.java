package com.example;


public class Product {

    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public boolean increaseStock(int amount) {

        if (amount <= 0) {
            return false;
        }

        stockQuantity += amount;
        return true;
    }

    public boolean decreaseStock(int amount) {

        if (amount <= 0 || amount > stockQuantity) {
            return false;
        }

        stockQuantity -= amount;
        return true;
    }

    public void displayProduct() {

        System.out.printf(
                "%-10d %-15s ₹%-14.2f %-10d%n",
                id, name, price, stockQuantity
        );
    }
}
