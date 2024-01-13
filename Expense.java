package com.expensetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Expense {
    private Date date;
    private String category;
    private double amount;

    // Constructors
    public Expense(Date date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public Expense() {
        // Default constructor
    }

    // Getters and setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static Expense enterExpense() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Expense Details:");

        // Get date
        System.out.print("Enter expense date (yyyy-MM-dd): ");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }

        // Get category
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        // Get amount
        System.out.print("Enter expense amount: ");
        double amount = 0;
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number for amount.");
            System.out.print("Enter expense amount: ");
            scanner.next(); // consume the invalid input
        }
        amount = scanner.nextDouble();

        return new Expense(date, category, amount);
   }
}