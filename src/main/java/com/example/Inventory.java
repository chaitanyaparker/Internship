package com.example;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {

        if (findById(product.getId()) != null) {
            return false;
        }

        products.add(product);
        return true;
    }

    public Product findById(int id) {

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void listProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n========== PRODUCT CATALOG ==========");

        System.out.printf(
                "%-10s %-15s %-15s %-10s%n",
                "ID", "Name", "Price", "Stock"
        );

        for (Product product : products) {
            product.displayProduct();
        }
    }

    public void lowStockAlert(int threshold) {

        boolean found = false;

        System.out.println("\n========== LOW STOCK ALERT ==========");

        for (Product product : products) {

            if (product.getStockQuantity() < threshold) {

                product.displayProduct();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products found.");
        }
    }
}

