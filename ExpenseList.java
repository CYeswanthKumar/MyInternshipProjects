package com.expensetracker;

import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
    private List<Expense> expenses;

    // Constructor
    public ExpenseList() {
        this.expenses = new ArrayList<>();
    }

    // Method to add expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    // Method to remove expense (if needed)
    public void removeExpense(Expense expense) {
        expenses.remove(expense);
        System.out.println("Expense removed successfully.");
    }

    // Method to display expenses
    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expense List:");
            for (Expense expense : expenses) {
                System.out.println("Date: " + expense.getDate() +
                        ", Category: " + expense.getCategory() +
                        ", Amount: $" + expense.getAmount());
            }
        }
    }

    // Getter method to retrieve the list of expenses
    public List<Expense> getExpenses() {
        return expenses;
    }
}