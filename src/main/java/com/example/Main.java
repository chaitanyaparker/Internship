package com.example;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        boolean running = true;

        while (running) {

            System.out.println("\n===== PRODUCT INVENTORY SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Increase Stock");
            System.out.println("4. Decrease Stock");
            System.out.println("5. Low Stock Alert");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Initial Stock: ");
                    int stock = scanner.nextInt();

                    if (id <= 0 || name.isBlank()
                            || price <= 0 || stock < 0) {

                        System.out.println("Invalid product details!");
                        break;
                    }

                    Product product = new Product(
                            id, name, price, stock
                    );

                    if (inventory.addProduct(product)) {
                        System.out.println("Product added successfully!");
                    } else {
                        System.out.println("Product ID already exists!");
                    }

                    break;

                case 2:

                    inventory.listProducts();
                    break;

                case 3:

                    System.out.print("Enter Product ID: ");
                    int increaseId = scanner.nextInt();

                    Product increaseProduct =
                            inventory.findById(increaseId);

                    if (increaseProduct == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter quantity to increase: ");
                    int increaseAmount = scanner.nextInt();

                    if (increaseProduct.increaseStock(increaseAmount)) {
                        System.out.println("Stock increased successfully!");
                    } else {
                        System.out.println("Invalid quantity!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Product ID: ");
                    int decreaseId = scanner.nextInt();

                    Product decreaseProduct =
                            inventory.findById(decreaseId);

                    if (decreaseProduct == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter quantity to decrease: ");
                    int decreaseAmount = scanner.nextInt();

                    if (decreaseProduct.decreaseStock(decreaseAmount)) {
                        System.out.println("Stock decreased successfully!");
                    } else {
                        System.out.println(
                                "Insufficient stock or invalid quantity!"
                        );
                    }

                    break;

                case 5:

                    System.out.print("Enter stock threshold: ");
                    int threshold = scanner.nextInt();

                    if (threshold < 0) {
                        System.out.println("Invalid threshold!");
                    } else {
                        inventory.lowStockAlert(threshold);
                    }

                    break;

                case 6:

                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;

                default:

                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
