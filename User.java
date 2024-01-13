package com.expensetracker;

import java.util.Scanner;

public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Registration:");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // You might want to add more validation and error handling here

        return new User(username, password);
    }
}