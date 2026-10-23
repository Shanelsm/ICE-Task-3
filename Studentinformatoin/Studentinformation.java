/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Studentinformatoin;

/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Studentinformation {
    static ArrayList<Login> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Login and Registration System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter 1, 2 or 3: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                registerUser();
            } else if (choice == 2) {
                loginUser();
            } else if (choice == 3) {
                System.out.println("Exiting system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    public static void registerUser() {
        System.out.println("\n--- Registration ---");
        System.out.print("Enter username (min 3 characters): ");
        String username = scanner.nextLine().trim();

        // Validation
        if (username.length() < 3) {
            System.out.println("Username too short. Must be at least 3 characters.");
            return;
        }

        // Check if exists
        for (Login u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }

        System.out.print("Enter password (min 4 characters): ");
        String password = scanner.nextLine().trim();

        if (password.length() < 4) {
            System.out.println("Password too short. Must be at least 4 characters.");
            return;
        }

        Login newUser = new Login(username, password);
        users.add(newUser);
        System.out.println("Registration successful!");
    }

    public static void loginUser() {
        System.out.println("\n--- Login ---");
        if (users.isEmpty()) {
            System.out.println("No users registered yet. Please register first.");
            return;
        }

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        boolean found = false;
        for (Login u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + username);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid username or password.");
        }
    }
}