package com.expensetracker;

import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        User user = User.registerUser();
        ExpenseList expenseList = new ExpenseList();
        CategorySummation categorySummation = new CategorySummation();
        FileHandler fileHandler = new FileHandler();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Enter Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Category-wise Summation");
            System.out.println("4. Save and Exit");

            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    Expense expense = Expense.enterExpense();
                    expenseList.addExpense(expense);
                    break;
                case 2:
                    expenseList.displayExpenses();
                    break;
                case 3:
                    categorySummation.calculateCategorySum(expenseList.getExpenses());
                    categorySummation.displayCategorySum();
                    break;
                case 4:
                    fileHandler.saveExpenses(expenseList.getExpenses());
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }
}