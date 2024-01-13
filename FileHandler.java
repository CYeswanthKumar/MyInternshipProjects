package com.expensetracker;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "expenses.txt";

    // Method to save expenses to a file
    public void saveExpenses(List<Expense> expenses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(expenses);
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    // Method to load expenses from a file
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                expenses = (List<Expense>) obj;
                System.out.println("Expenses loaded successfully.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved expenses found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses from file: " + e.getMessage());
        }

        return expenses;
    }
}